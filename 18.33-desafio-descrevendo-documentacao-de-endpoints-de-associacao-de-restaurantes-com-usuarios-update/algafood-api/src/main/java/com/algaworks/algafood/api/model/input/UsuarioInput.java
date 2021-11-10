package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioInput {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
}
