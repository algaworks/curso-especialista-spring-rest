package com.algaworks.algafood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.FormaPagamentoInputDisassembler;
import com.algaworks.algafood.api.assembler.FormaPagamentoModelAssembler;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.api.model.input.FormaPagamentoInput;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamento;
	
	@Autowired
	private FormaPagamentoModelAssembler formaPagamentoModelAssembler;
	
	@Autowired
	private FormaPagamentoInputDisassembler formaPagamentoInputDisassembler;
	
	@GetMapping
	public List<FormaPagamentoModel> listar() {
		List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.findAll();
		
		return formaPagamentoModelAssembler.toCollectionModel(todasFormasPagamentos);
	}
	
	@GetMapping("/{formaPagamentoId}")
	public FormaPagamentoModel buscar(@PathVariable Long formaPagamentoId) {
		FormaPagamento formaPagamento = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);
		
		return formaPagamentoModelAssembler.toModel(formaPagamento);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamentoModel adicionar(@RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {
		FormaPagamento formaPagamento = formaPagamentoInputDisassembler.toDomainObject(formaPagamentoInput);
		
		formaPagamento = cadastroFormaPagamento.salvar(formaPagamento);
		
		return formaPagamentoModelAssembler.toModel(formaPagamento);
	}
	
	@PutMapping("/{formaPagamentoId}")
	public FormaPagamentoModel atualizar(@PathVariable Long formaPagamentoId,
			@RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {
		FormaPagamento formaPagamentoAtual = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);
		
		formaPagamentoInputDisassembler.copyToDomainObject(formaPagamentoInput, formaPagamentoAtual);
		
		formaPagamentoAtual = cadastroFormaPagamento.salvar(formaPagamentoAtual);
		
		return formaPagamentoModelAssembler.toModel(formaPagamentoAtual);
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long formaPagamentoId) {
		cadastroFormaPagamento.excluir(formaPagamentoId);	
	}
	
}
