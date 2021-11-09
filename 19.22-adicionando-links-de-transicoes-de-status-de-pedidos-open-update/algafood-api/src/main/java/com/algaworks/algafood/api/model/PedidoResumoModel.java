package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Relation(collectionRelation = "pedidos")
@Setter
@Getter
public class PedidoResumoModel extends RepresentationModel<PedidoResumoModel> {

	@ApiModelProperty(example = "f9981ca4-5a5e-4da3-af04-933861df3e55")
	private String codigo;

	@ApiModelProperty(example = "298.90")
	private BigDecimal subtotal;

	@ApiModelProperty(example = "10.00")
	private BigDecimal taxaFrete;

	@ApiModelProperty(example = "308.90")
	private BigDecimal valorTotal;

	@ApiModelProperty(example = "CRIADO")
	private String status;

	@ApiModelProperty(example = "2019-12-01T20:34:04Z")
	private OffsetDateTime dataCriacao;

	private RestauranteResumoModel restaurante;
	private UsuarioModel cliente;

}
