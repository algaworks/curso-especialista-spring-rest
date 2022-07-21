package com.algaworks.algafood.api.v1.openapi.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "security_auth")
public interface FluxoPedidoControllerOpenApi {

	ResponseEntity<Void> confirmar(String codigoPedido);

	ResponseEntity<Void> cancelar(String codigoPedido);

	ResponseEntity<Void> entregar(String codigoPedido);

}