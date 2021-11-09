package com.algaworks.algafood.api.v2.openapi.model;

import com.algaworks.algafood.api.v1.model.CozinhaModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Links;

import java.util.List;

@ApiModel("CozinhasModel")
@Setter
@Getter
public class CozinhasModelV2OpenApi {
	
	
	private CozinhasEmbeddedModelOpenApi _embedded;
	private Links _links;
	private PageModelV2OpenApi page;
	
	@ApiModel("CozinhasEmbeddedModel")
	@Data
	public class CozinhasEmbeddedModelOpenApi {
		
		private List<CozinhaModel> cozinhas;
		
	}
	
}
