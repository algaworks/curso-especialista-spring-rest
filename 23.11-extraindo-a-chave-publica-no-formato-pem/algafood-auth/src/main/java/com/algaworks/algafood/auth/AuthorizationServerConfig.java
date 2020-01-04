package com.algaworks.algafood.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtKeyStoreProperties jwtKeyStoreProperties;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
				.withClient("algafood-web")
				.secret(passwordEncoder.encode("web123"))
				.authorizedGrantTypes("password", "refresh_token")
				.scopes("write", "read")
				.accessTokenValiditySeconds(6 * 60 * 60)// 6 horas
				.refreshTokenValiditySeconds(60 * 24 * 60 * 60) // 60 dias
			
			.and()
				.withClient("foodanalytics")
				.secret(passwordEncoder.encode(""))
				.authorizedGrantTypes("authorization_code")
				.scopes("write", "read")
				.redirectUris("http://www.foodanalytics.local:8082")
			
			.and()
				.withClient("webadmin")
				.authorizedGrantTypes("implicit")
				.scopes("write", "read")
				.redirectUris("http://aplicacao-cliente")
				
			.and()
				.withClient("faturamento")
				.secret(passwordEncoder.encode("faturamento123"))
				.authorizedGrantTypes("client_credentials")
				.scopes("write", "read")
				
			.and()
				.withClient("checktoken")
					.secret(passwordEncoder.encode("check123"));
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.checkTokenAccess("isAuthenticated()");
		security.checkTokenAccess("permitAll()")
			.tokenKeyAccess("permitAll()")
			.allowFormAuthenticationForClients();
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService)
			.reuseRefreshTokens(false)
			.accessTokenConverter(jwtAccessTokenConverter())
			.tokenGranter(tokenGranter(endpoints));
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		var jwtAccessTokenConverter = new JwtAccessTokenConverter();
		
		var jksResource = new ClassPathResource(jwtKeyStoreProperties.getPath());
		var keyStorePass = jwtKeyStoreProperties.getPassword();
		var keyPairAlias = jwtKeyStoreProperties.getKeypairAlias();
		
		var keyStoreKeyFactory = new KeyStoreKeyFactory(jksResource, keyStorePass.toCharArray());
		var keyPair = keyStoreKeyFactory.getKeyPair(keyPairAlias);
		
		jwtAccessTokenConverter.setKeyPair(keyPair);
		
		return jwtAccessTokenConverter;
	}
	
	private TokenGranter tokenGranter(AuthorizationServerEndpointsConfigurer endpoints) {
		var pkceAuthorizationCodeTokenGranter = new PkceAuthorizationCodeTokenGranter(endpoints.getTokenServices(),
				endpoints.getAuthorizationCodeServices(), endpoints.getClientDetailsService(),
				endpoints.getOAuth2RequestFactory());
		
		var granters = Arrays.asList(
				pkceAuthorizationCodeTokenGranter, endpoints.getTokenGranter());
		
		return new CompositeTokenGranter(granters);
	}
	
}
