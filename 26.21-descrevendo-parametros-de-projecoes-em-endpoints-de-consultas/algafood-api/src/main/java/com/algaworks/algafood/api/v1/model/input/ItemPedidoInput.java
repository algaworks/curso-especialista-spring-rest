package com.algaworks.algafood.api.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ItemPedidoInput {

    @Schema(example = "1")
    @NotNull
    private Long produtoId;

    @Schema(example = "2")
    @Min(1)
    @NotNull
    private Integer quantidade;

    @Schema(example = "Menos picante, por favor")
    private String observacao;

}
