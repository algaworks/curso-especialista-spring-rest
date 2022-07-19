package com.algaworks.algafood.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Schema(name = "Problema")
@JsonInclude(Include.NON_NULL)
@Builder
@Getter
public class Problem {

	@Schema(example = "400")
	private Integer status;

	@Schema(example = "https://algafood.com.br/dados-invalidos")
	private String type;

	@Schema(example = "Dados inválidos")
	private String title;

	@Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
	private String detail;

	@Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
	private String userMessage;

	@Schema(example = "2022-02-07T01:28:57.902245498Z")
	private OffsetDateTime timestamp;

	@Schema(description = "Lista de objetos ou campos que geraram o erro (opcional)")
	private List<Object> objects;

	@Schema(name = "ObjetoProblema")
	@Builder
	@Getter
	public static class Object {

		@Schema(example = "preco")
		private String name;

		@Schema(example = "O preço é obrigatório")
		private String userMessage;

	}

}
