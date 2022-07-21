package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.PedidoModel;
import com.algaworks.algafood.api.v1.model.PedidoResumoModel;
import com.algaworks.algafood.api.v1.model.input.PedidoInput;
import com.algaworks.algafood.domain.filter.PedidoFilter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

@SecurityRequirement(name = "security_auth")
public interface PedidoControllerOpenApi {

	PagedModel<PedidoResumoModel> pesquisar(PedidoFilter filtro, Pageable pageable);

	PedidoModel adicionar(PedidoInput pedidoInput);

	PedidoModel buscar(String codigoPedido);
	
}
