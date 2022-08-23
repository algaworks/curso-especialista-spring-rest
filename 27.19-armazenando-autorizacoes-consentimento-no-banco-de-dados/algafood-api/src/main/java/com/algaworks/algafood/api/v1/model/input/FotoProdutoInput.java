package com.algaworks.algafood.api.v1.model.input;

import com.algaworks.algafood.core.validation.FileContentType;
import com.algaworks.algafood.core.validation.FileSize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FotoProdutoInput {

    @Schema(description = "Arquivo da foto do produto (máximo 2MB, apenas JPG e PNG)")
    @FileSize(max = "500KB")
    @FileContentType(allowed = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
    @NotNull
    private MultipartFile arquivo;

    @Schema(description = "Descrição da foto do produto")
    @NotBlank
    private String descricao;

}
