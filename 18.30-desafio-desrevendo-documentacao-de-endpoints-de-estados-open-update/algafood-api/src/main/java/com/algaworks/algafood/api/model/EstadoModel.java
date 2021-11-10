package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoModel {

	@ApiModelProperty(example = "1")
	private Long id;

	@ApiModelProperty(example = "Minas Gerais")
	private String nome;

}
