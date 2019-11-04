package com.algaworks.algafood.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.StatusPedido;

@Service
public class FluxoPedidoService {

	@Autowired
	private EmissaoPedidoService emissaoPedido;
	
	@Transactional
	public void confirmar(Long pedidoId) {
		Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoId);
		
		if (!pedido.getStatus().equals(StatusPedido.CRIADO)) {
			throw new NegocioException(
					String.format("Status do pedido %d não pode ser alterado de %s para %s",
							pedido.getId(), pedido.getStatus().getDescricao(), 
							StatusPedido.CONFIRMADO.getDescricao()));
		}
		
		pedido.setStatus(StatusPedido.CONFIRMADO);
		pedido.setDataConfirmacao(OffsetDateTime.now());
	}
	
	@Transactional
	public void cancelar(Long pedidoId) {
		Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoId);
		
		if (!pedido.getStatus().equals(StatusPedido.CRIADO)) {
			throw new NegocioException(
					String.format("Status do pedido %d não pode ser alterado de %s para %s",
							pedido.getId(), pedido.getStatus().getDescricao(), 
							StatusPedido.CANCELADO.getDescricao()));
		}
		
		pedido.setStatus(StatusPedido.CANCELADO);
		pedido.setDataCancelamento(OffsetDateTime.now());
	}
	
	@Transactional
	public void entregar(Long pedidoId) {
		Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoId);
		
		if (!pedido.getStatus().equals(StatusPedido.CONFIRMADO)) {
			throw new NegocioException(
					String.format("Status do pedido %d não pode ser alterado de %s para %s",
							pedido.getId(), pedido.getStatus().getDescricao(), 
							StatusPedido.ENTREGUE.getDescricao()));
		}
		
		pedido.setStatus(StatusPedido.ENTREGUE);
		pedido.setDataEntrega(OffsetDateTime.now());
	}
	
}
