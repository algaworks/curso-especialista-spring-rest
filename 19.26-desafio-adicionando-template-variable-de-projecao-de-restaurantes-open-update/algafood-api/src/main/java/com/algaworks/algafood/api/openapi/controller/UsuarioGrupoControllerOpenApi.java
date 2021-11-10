package com.algaworks.algafood.api.openapi.controller;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api(tags = "Usuários")
public interface UsuarioGrupoControllerOpenApi {

	@ApiOperation("Lista os grupos associados a um usuário")
	@ApiResponses({
			@ApiResponse(code = 404, message = "Usuário não encontrado", response = Problem.class)
	})
	List<GrupoModel> listar(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
					Long usuarioId);

	@ApiOperation("Desassociação de grupo com usuário")
	@ApiResponses({
			@ApiResponse(code = 204, message = "Desassociação realizada com sucesso"),
			@ApiResponse(code = 404, message = "Usuário ou grupo não encontrado",
					response = Problem.class)
	})
	void desassociar(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
					Long usuarioId,

			@ApiParam(value = "ID do grupo", example = "1", required = true)
					Long grupoId);

	@ApiOperation("Associação de grupo com usuário")
	@ApiResponses({
			@ApiResponse(code = 204, message = "Associação realizada com sucesso"),
			@ApiResponse(code = 404, message = "Usuário ou grupo não encontrado",
					response = Problem.class)
	})
	void associar(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
					Long usuarioId,

			@ApiParam(value = "ID do grupo", example = "1", required = true)
					Long grupoId);

}