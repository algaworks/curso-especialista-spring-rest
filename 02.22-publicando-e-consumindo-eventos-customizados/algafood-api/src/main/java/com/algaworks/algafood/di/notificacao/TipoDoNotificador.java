package com.algaworks.algafood.di.notificacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface TipoDoNotificador {

	NivelUrgencia value();
	
}
