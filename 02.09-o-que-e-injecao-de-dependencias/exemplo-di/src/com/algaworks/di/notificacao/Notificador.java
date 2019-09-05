package com.algaworks.di.notificacao;

import com.algaworks.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);
	
}
