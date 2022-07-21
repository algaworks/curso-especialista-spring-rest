package com.algaworks.algafood.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;

@Relation(collectionRelation = "restaurantes")
@Setter
@Getter
public class RestauranteBasicoModel extends RepresentationModel<RestauranteBasicoModel> {

	@Schema(example = "1")
	private Long id;

	@Schema(example = "Thai Gourmet")
	private String nome;

	@Schema(example = "12.00")
	private BigDecimal taxaFrete;
	private CozinhaModel cozinha;
	
}
