package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.CidadeModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("CidadesModel")
@Data
public class CidadesModelOpenApi {

	private CidadesEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("CidadesEmbeddedModel")
	@Data
	public class CidadesEmbeddedModelOpenApi {
		
		private List<CidadeModel> cidades;
		
	}
	
}
