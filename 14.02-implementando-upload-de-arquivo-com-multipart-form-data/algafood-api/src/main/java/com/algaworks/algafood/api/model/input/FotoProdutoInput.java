package com.algaworks.algafood.api.model.input;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoProdutoInput {

	private MultipartFile arquivo;
	private String descricao;
	
}
