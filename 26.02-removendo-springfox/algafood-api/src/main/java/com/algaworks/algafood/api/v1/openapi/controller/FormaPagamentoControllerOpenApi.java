package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.FormaPagamentoModel;
import com.algaworks.algafood.api.v1.model.input.FormaPagamentoInput;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;

public interface FormaPagamentoControllerOpenApi {

	ResponseEntity<CollectionModel<FormaPagamentoModel>> listar(ServletWebRequest request);

	ResponseEntity<FormaPagamentoModel> buscar(Long formaPagamentoId, ServletWebRequest request);

	FormaPagamentoModel adicionar(FormaPagamentoInput formaPagamentoInput);

	FormaPagamentoModel atualizar(Long formaPagamentoId,FormaPagamentoInput formaPagamentoInput);

	ResponseEntity<Void> remover(Long formaPagamentoId);
	
}
