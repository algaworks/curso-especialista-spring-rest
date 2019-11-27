package com.algaworks.algafood.client.model;

import lombok.Data;

@Data
public class EnderecoModel {

	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private CidadeResumoModel cidade;

}