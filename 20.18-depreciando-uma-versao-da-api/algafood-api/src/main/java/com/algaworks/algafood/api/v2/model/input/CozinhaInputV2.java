package com.algaworks.algafood.api.v2.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CozinhaInput")
@Setter
@Getter
public class CozinhaInputV2 {

	@ApiModelProperty(example = "Brasileira", required = true)
	@NotBlank
	private String nomeCozinha;
	
}
