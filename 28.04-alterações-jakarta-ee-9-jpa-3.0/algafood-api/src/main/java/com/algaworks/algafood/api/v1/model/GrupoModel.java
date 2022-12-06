package com.algaworks.algafood.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "grupos")
@Setter
@Getter
public class GrupoModel extends RepresentationModel<GrupoModel> {
	@Schema(example = "1")
	private Long id;

	@Schema(example = "Gerente")
	private String nome;
}
