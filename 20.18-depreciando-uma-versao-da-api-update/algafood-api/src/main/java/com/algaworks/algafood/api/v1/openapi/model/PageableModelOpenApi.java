package com.algaworks.algafood.api.v1.openapi.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel("Pageable")
@Setter
@Getter
public class PageableModelOpenApi {

	@ApiModelProperty(example = "0", value = "Número da página (começa em 0)")
	private int page;

	@ApiModelProperty(example = "10", value = "Quantidade de elementos por página")
	private int size;

	@ApiModelProperty(example = "nome,asc", value = "Nome da propriedade para ordenação")
	private List<String> sort;

}
