package com.algaworks.di.modelo;

import java.math.BigDecimal;

public class Produto {

	private String nome;
	private BigDecimal valorTotal;

	public Produto(String nome, BigDecimal valorTotal) {
		super();
		this.nome = nome;
		this.valorTotal = valorTotal;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

}
