package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.CozinhaModel;
import com.algaworks.algafood.api.v1.model.input.CozinhaInput;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;

public interface CozinhaControllerOpenApi {

	PagedModel<CozinhaModel> listar(@Parameter(hidden = true) Pageable pageable);

	CozinhaModel buscar(Long cozinhaId);

	CozinhaModel adicionar(CozinhaInput cozinhaInput);

	CozinhaModel atualizar(Long cozinhaId, CozinhaInput cozinhaInput);

	ResponseEntity<Void> remover(Long cozinhaId);
	
}
