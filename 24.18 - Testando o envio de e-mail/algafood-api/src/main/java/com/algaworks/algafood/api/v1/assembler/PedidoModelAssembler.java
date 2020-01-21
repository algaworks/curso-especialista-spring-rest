package com.algaworks.algafood.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.PedidoController;
import com.algaworks.algafood.api.v1.model.PedidoModel;
import com.algaworks.algafood.core.security.AlgaSecurity;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoModelAssembler 
		extends RepresentationModelAssemblerSupport<Pedido, PedidoModel> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AlgaLinks algaLinks;
	
	@Autowired
	private AlgaSecurity algaSecurity;

	public PedidoModelAssembler() {
		super(PedidoController.class, PedidoModel.class);
	}
	
	@Override
	public PedidoModel toModel(Pedido pedido) {
		PedidoModel pedidoModel = createModelWithId(pedido.getCodigo(), pedido);
		modelMapper.map(pedido, pedidoModel);
		
		// Não usei o método algaSecurity.podePesquisarPedidos(clienteId, restauranteId) aqui,
		// porque na geração do link, não temos o id do cliente e do restaurante, 
		// então precisamos saber apenas se a requisição está autenticada e tem o escopo de leitura
		if (algaSecurity.podePesquisarPedidos()) {
			pedidoModel.add(algaLinks.linkToPedidos("pedidos"));
		}
		
		if (algaSecurity.podeGerenciarPedidos(pedido.getCodigo())) {
			if (pedido.podeSerConfirmado()) {
				pedidoModel.add(algaLinks.linkToConfirmacaoPedido(pedido.getCodigo(), "confirmar"));
			}
			
			if (pedido.podeSerCancelado()) {
				pedidoModel.add(algaLinks.linkToCancelamentoPedido(pedido.getCodigo(), "cancelar"));
			}
			
			if (pedido.podeSerEntregue()) {
				pedidoModel.add(algaLinks.linkToEntregaPedido(pedido.getCodigo(), "entregar"));
			}
		}
		
		if (algaSecurity.podeConsultarRestaurantes()) {
			pedidoModel.getRestaurante().add(
					algaLinks.linkToRestaurante(pedido.getRestaurante().getId()));
		}
		
		if (algaSecurity.podeConsultarUsuariosGruposPermissoes()) {
			pedidoModel.getCliente().add(
					algaLinks.linkToUsuario(pedido.getCliente().getId()));
		}
		
		if (algaSecurity.podeConsultarFormasPagamento()) {
			pedidoModel.getFormaPagamento().add(
					algaLinks.linkToFormaPagamento(pedido.getFormaPagamento().getId()));
		}
		
		if (algaSecurity.podeConsultarCidades()) {
			pedidoModel.getEnderecoEntrega().getCidade().add(
					algaLinks.linkToCidade(pedido.getEnderecoEntrega().getCidade().getId()));
		}
		
		// Quem pode consultar restaurantes, também pode consultar os produtos dos restaurantes
		if (algaSecurity.podeConsultarRestaurantes()) {
			pedidoModel.getItens().forEach(item -> {
				item.add(algaLinks.linkToProduto(
						pedidoModel.getRestaurante().getId(), item.getProdutoId(), "produto"));
			});
		}
		
		return pedidoModel;
	}

}
