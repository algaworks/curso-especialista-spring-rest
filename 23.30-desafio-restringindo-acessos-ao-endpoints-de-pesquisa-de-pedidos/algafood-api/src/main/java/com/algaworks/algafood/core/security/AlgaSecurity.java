package com.algaworks.algafood.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class AlgaSecurity {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public Long getUsuarioId() {
		Jwt jwt = (Jwt) getAuthentication().getPrincipal();
		
		return jwt.getClaim("usuario_id");
	}
	
	public boolean gerenciaRestaurante(Long restauranteId) {
		if (restauranteId == null) {
			return false;
		}
		
		return restauranteRepository.existsResponsavel(restauranteId, getUsuarioId());
	}
	
}
