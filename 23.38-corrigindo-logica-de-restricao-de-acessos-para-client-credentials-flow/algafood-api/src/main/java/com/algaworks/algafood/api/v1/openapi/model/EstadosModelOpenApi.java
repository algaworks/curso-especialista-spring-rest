package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.EstadoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("EstadosModel")
@Data
public class EstadosModelOpenApi {

	private EstadosEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("EstadosEmbeddedModel")
	@Data
	public class EstadosEmbeddedModelOpenApi {
		
		private List<EstadoModel> estados;
		
	}
	
}
