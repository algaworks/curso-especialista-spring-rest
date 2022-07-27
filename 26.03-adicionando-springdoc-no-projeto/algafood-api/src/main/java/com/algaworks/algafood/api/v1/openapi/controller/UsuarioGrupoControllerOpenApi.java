package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.GrupoModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

public interface UsuarioGrupoControllerOpenApi {
	CollectionModel<GrupoModel> listar(Long usuarioId);

	ResponseEntity<Void> desassociar(Long usuarioId,Long grupoId);

	ResponseEntity<Void> associar(Long usuarioId,Long grupoId);

}