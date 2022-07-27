package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.CidadeModel;
import com.algaworks.algafood.api.v1.model.input.CidadeInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Cidades")
public interface CidadeControllerOpenApi {

	@Operation(summary = "Lista as cidades")
	CollectionModel<CidadeModel> listar();

	@Operation(summary = "Busca uma cidade por Id")
	CidadeModel buscar(Long cidadeId);

	@Operation(summary = "Cadastra uma cidade", description = "Cadastro de uma cidade, " +
			"necessita de um estado e um nome válido")
	CidadeModel adicionar(CidadeInput cidadeInput);

	@Operation(summary = "Atualizado uma cidade por ID")
	CidadeModel atualizar(Long cidadeId, CidadeInput cidadeInput);

	@Operation(summary = "Excluir uma cidade por ID")
	ResponseEntity<Void> remover(Long cidadeId);
	
}
