package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.CidadeModel;
import com.algaworks.algafood.api.v1.model.input.CidadeInput;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "security_auth")
public interface CidadeControllerOpenApi {

	CollectionModel<CidadeModel> listar();

	CidadeModel buscar(Long cidadeId);

	CidadeModel adicionar(CidadeInput cidadeInput);

	CidadeModel atualizar(Long cidadeId, CidadeInput cidadeInput);

	ResponseEntity<Void> remover(Long cidadeId);
	
}
