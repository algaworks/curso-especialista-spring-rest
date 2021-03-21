package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "produtos")
@Setter
@Getter
public class ProdutoModel extends RepresentationModel<ProdutoModel> {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Espetinho de Cupim")
	private String nome;
	
	@ApiModelProperty(example = "Acompanha farinha, mandioca e vinagrete")
	private String descricao;
	
	@ApiModelProperty(example = "12.50")
	private BigDecimal preco;
	
	@ApiModelProperty(example = "true")
	private Boolean ativo;
	
}
