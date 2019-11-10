package com.algaworks.algafood.infrastructure.service.storage;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.service.FotoStorageService;

@Service
public class S3FotoStorageService implements FotoStorageService {

	@Override
	public InputStream recuperar(String nomeArquivo) {
		return null;
	}

	@Override
	public void armazenar(NovaFoto novaFoto) {
	}

	@Override
	public void remover(String nomeArquivo) {
	}

}
