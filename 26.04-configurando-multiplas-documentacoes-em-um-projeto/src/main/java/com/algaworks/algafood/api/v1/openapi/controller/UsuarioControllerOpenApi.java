package com.algaworks.algafood.api.v1.openapi.controller;

import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.api.v1.model.input.SenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioComSenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioInput;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

public interface UsuarioControllerOpenApi {

	CollectionModel<UsuarioModel> listar();

	UsuarioModel buscar(Long usuarioId);

	UsuarioModel adicionar(UsuarioComSenhaInput usuarioInput);

	UsuarioModel atualizar(Long usuarioId,UsuarioInput usuarioInput);

	ResponseEntity<Void> alterarSenha(Long usuarioId,SenhaInput senha);

}