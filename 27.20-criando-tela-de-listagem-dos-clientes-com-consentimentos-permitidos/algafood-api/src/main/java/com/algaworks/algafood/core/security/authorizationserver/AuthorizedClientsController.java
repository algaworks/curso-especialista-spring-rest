package com.algaworks.algafood.core.security.authorizationserver;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorizedClientsController {

    private final OAuth2AuthorizationQueryService oAuth2AuthorizationQueryService;

    @GetMapping("/oauth2/authorized-clients")
    public String clientList(Principal principal, Model model) {
        List<RegisteredClient> clients = oAuth2AuthorizationQueryService.listClientsWithConsent(principal.getName());
        model.addAttribute("clients", clients);
        return "pages/authorized-clients";
    }

}
