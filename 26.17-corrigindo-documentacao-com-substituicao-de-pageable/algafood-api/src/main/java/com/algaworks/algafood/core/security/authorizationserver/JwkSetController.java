package com.algaworks.algafood.core.security.authorizationserver;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.jwk.JWKSet;

@RestController
public class JwkSetController {

	@Autowired
	private JWKSet jwkSet;
	
	@GetMapping("/.well-known/jwks.json")
	public Map<String, Object> keys() {
		return this.jwkSet.toJSONObject();
	}
	
}
