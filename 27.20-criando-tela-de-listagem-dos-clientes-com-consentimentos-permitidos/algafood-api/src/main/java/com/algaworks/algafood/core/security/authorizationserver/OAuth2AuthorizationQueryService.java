package com.algaworks.algafood.core.security.authorizationserver;

import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import java.util.List;

public interface OAuth2AuthorizationQueryService {

    List<RegisteredClient> listClientsWithConsent(String principalName);

}
