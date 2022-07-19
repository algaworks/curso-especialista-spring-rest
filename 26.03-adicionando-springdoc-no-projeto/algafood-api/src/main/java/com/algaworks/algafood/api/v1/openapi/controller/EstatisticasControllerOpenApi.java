package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.controller.EstatisticasController.EstatisticasModel;
import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.domain.model.dto.VendaDiaria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstatisticasControllerOpenApi {

	EstatisticasModel estatisticas();

	List<VendaDiaria> consultarVendasDiarias(
			VendaDiariaFilter filtro,String timeOffset);

	ResponseEntity<byte[]> consultarVendasDiariasPdf(
			VendaDiariaFilter filtro,
			String timeOffset);

}