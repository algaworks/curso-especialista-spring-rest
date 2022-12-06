package com.algaworks.algafood.core.security.authorizationserver;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class AuthorizationConsentController {
    private final RegisteredClientRepository registeredClientRepository;
    private final OAuth2AuthorizationConsentService consentService;

    @GetMapping("/oauth2/consent")
    public String consent(
            Principal principal,
            Model model,
            @RequestParam(OAuth2ParameterNames.CLIENT_ID) String clientId,
            @RequestParam(OAuth2ParameterNames.SCOPE) String scope,
            @RequestParam(OAuth2ParameterNames.STATE) String state
    ) {
        RegisteredClient client = this.registeredClientRepository.findByClientId(clientId);

        if(client == null) {
            throw new AccessDeniedException(String.format("Cliente de %s não foi encontrado", clientId));
        }

        OAuth2AuthorizationConsent consent = this.consentService.findById(client.getId(), principal.getName());

        String[] scopeArray = StringUtils.delimitedListToStringArray(scope, " ");
        Set<String> scopesParaAprovar = new HashSet<>(Set.of(scopeArray));

        Set<String> scopesAprovadosAnteriormente;
        if (consent != null) {
            scopesAprovadosAnteriormente = consent.getScopes();
            scopesParaAprovar.removeAll(scopesAprovadosAnteriormente);
        } else {
            scopesAprovadosAnteriormente = Collections.emptySet();
        }

        model.addAttribute("clientId", clientId);
        model.addAttribute("state", state);
        model.addAttribute("principalName", principal.getName());
        model.addAttribute("scopesParaAprovar", scopesParaAprovar);
        model.addAttribute("scopesAprovadosAnteriormente", scopesAprovadosAnteriormente);

        return "pages/approval";
    }

}
