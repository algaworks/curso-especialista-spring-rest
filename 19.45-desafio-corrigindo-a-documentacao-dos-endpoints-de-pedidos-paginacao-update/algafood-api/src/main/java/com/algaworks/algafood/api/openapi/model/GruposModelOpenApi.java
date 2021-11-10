package com.algaworks.algafood.api.openapi.model;

import com.algaworks.algafood.api.model.GrupoModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.hateoas.Links;

import java.util.List;

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
