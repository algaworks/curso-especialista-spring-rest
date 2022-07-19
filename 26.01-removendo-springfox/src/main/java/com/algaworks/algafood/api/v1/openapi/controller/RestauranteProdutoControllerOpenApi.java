package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.ProdutoModel;
import com.algaworks.algafood.api.v1.model.input.ProdutoInput;
import org.springframework.hateoas.CollectionModel;

public interface RestauranteProdutoControllerOpenApi {

	CollectionModel<ProdutoModel> listar(Long restauranteId,Boolean incluirInativos);

	ProdutoModel buscar(Long restauranteId,Long produtoId);

	ProdutoModel adicionar(Long restauranteId,ProdutoInput produtoInput);

	ProdutoModel atualizar(Long restauranteId,Long produtoId,ProdutoInput produtoInput);

}