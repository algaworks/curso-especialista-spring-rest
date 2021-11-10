package com.algaworks.algafood.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoInput {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	@PositiveOrZero
	private BigDecimal preco;
	
	@NotNull
	private Boolean ativo;
	
}
