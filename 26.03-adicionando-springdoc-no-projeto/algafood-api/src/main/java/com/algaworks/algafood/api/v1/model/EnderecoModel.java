package com.algaworks.algafood.api.v1.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoModel {
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private CidadeResumoModel cidade;
	
}
