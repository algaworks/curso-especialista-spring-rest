package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.GrupoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("GruposModel")
@Data
public class GruposModelOpenApi {

	private GruposEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("GruposEmbeddedModel")
	@Data
	public class GruposEmbeddedModelOpenApi {
		
		private List<GrupoModel> grupos;
		
	}
	
}
