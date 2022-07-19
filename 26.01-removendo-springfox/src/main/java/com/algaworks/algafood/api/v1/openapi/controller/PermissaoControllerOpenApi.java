package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.PermissaoModel;
import org.springframework.hateoas.CollectionModel;

public interface PermissaoControllerOpenApi {

	CollectionModel<PermissaoModel> listar();
	
}
