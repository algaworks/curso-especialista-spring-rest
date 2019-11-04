package com.algaworks.algafood.domain.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class VendaDiaria {

	private LocalDate data;
	private Long totalVendas;
	private BigDecimal totalFaturado;
	
}
