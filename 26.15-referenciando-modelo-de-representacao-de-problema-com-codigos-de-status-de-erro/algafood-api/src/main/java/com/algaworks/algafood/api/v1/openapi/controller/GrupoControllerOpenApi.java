package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.GrupoModel;
import com.algaworks.algafood.api.v1.model.input.GrupoInput;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "security_auth")
public interface GrupoControllerOpenApi {

	CollectionModel<GrupoModel> listar();

	GrupoModel buscar(Long grupoId);

	GrupoModel adicionar(GrupoInput grupoInput);

	GrupoModel atualizar(Long grupoId, GrupoInput grupoInput);

	ResponseEntity<Void> remover(Long grupoId);
	
}
