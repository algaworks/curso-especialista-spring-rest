package com.algaworks.algafood.core.security.authorizationserver;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorizedClientsController {

    private final OAuth2AuthorizationQueryService oAuth2AuthorizationQueryService;
    private final RegisteredClientRepository clientRepository;
    private final OAuth2AuthorizationConsentService oAuth2AuthorizationConsentService;
    private final OAuth2AuthorizationService auth2AuthorizationService;

    @GetMapping("/oauth2/authorized-clients")
    public String clientList(Principal principal, Model model) {
        List<RegisteredClient> clients = oAuth2AuthorizationQueryService.listClientsWithConsent(principal.getName());
        model.addAttribute("clients", clients);
        return "pages/authorized-clients";
    }

    @PostMapping("/oauth2/authorized-clients/revoke")
    public String revoke(Principal principal,
                         Model model,
                         @RequestParam(OAuth2ParameterNames.CLIENT_ID) String clientId) {
        RegisteredClient registeredClient = this.clientRepository.findByClientId(clientId);

        if(registeredClient == null) {
            throw new AccessDeniedException(String.format("Cliente %s não encontrado", clientId));
        }

        OAuth2AuthorizationConsent conset = this.oAuth2AuthorizationConsentService.findById(registeredClient.getId(),
                principal.getName());

        List<OAuth2Authorization> authorizations = this.oAuth2AuthorizationQueryService.listAuthorizations(
                principal.getName(), registeredClient.getId());

        if(conset != null) {
            this.oAuth2AuthorizationConsentService.remove(conset);
        }

        for (OAuth2Authorization authorization : authorizations) {
            this.auth2AuthorizationService.remove(authorization);
        }

        return "redirect:/oauth2/authorized-clients";
    }

}
