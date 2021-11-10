package com.algaworks.algafood.api.openapi.controller;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.PermissaoModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api(tags = "Grupos")
public interface GrupoPermissaoControllerOpenApi {

	@ApiOperation("Lista as permissões associadas a um grupo")
	@ApiResponses({
			@ApiResponse(code = 400, message = "ID do grupo inválido", response = Problem.class),
			@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
	})
	List<PermissaoModel> listar(
			@ApiParam(value = "ID do grupo", example = "1", required = true)
					Long grupoId);

	@ApiOperation("Desassociação de permissão com grupo")
	@ApiResponses({
			@ApiResponse(code = 204, message = "Desassociação realizada com sucesso"),
			@ApiResponse(code = 404, message = "Grupo ou permissão não encontrada",
					response = Problem.class)
	})
	void desassociar(
			@ApiParam(value = "ID do grupo", example = "1", required = true)
					Long grupoId,

			@ApiParam(value = "ID da permissão", example = "1", required = true)
					Long permissaoId);

	@ApiOperation("Associação de permissão com grupo")
	@ApiResponses({
			@ApiResponse(code = 204, message = "Associação realizada com sucesso"),
			@ApiResponse(code = 404, message = "Grupo ou permissão não encontrada",
					response = Problem.class)
	})
	void associar(
			@ApiParam(value = "ID do grupo", example = "1", required = true)
					Long grupoId,

			@ApiParam(value = "ID da permissão", example = "1", required = true)
					Long permissaoId);

}