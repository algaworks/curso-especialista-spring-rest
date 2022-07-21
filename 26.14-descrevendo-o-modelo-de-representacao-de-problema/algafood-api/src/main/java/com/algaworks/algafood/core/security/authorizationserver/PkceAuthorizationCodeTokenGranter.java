package com.algaworks.algafood.core.security.authorizationserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

public class PkceAuthorizationCodeTokenGranter extends AuthorizationCodeTokenGranter {

	public PkceAuthorizationCodeTokenGranter(AuthorizationServerTokenServices tokenServices,
			AuthorizationCodeServices authorizationCodeServices, ClientDetailsService clientDetailsService,
			OAuth2RequestFactory requestFactory) {
		super(tokenServices, authorizationCodeServices, clientDetailsService, requestFactory);
	}

	@Override
	protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
		OAuth2Authentication authentication = super.getOAuth2Authentication(client, tokenRequest);
		OAuth2Request request = authentication.getOAuth2Request();

		String codeChallenge = request.getRequestParameters().get("code_challenge");
		String codeChallengeMethod = request.getRequestParameters().get("code_challenge_method");
		String codeVerifier = request.getRequestParameters().get("code_verifier");

		if (codeChallenge != null || codeChallengeMethod != null) {
			if (codeVerifier == null) {
				throw new InvalidGrantException("Code verifier expected.");
			}
			
			if (!validateCodeVerifier(codeVerifier, codeChallenge, codeChallengeMethod)) {
				throw new InvalidGrantException(codeVerifier + " does not match expected code verifier.");
			}
		}
		
		return authentication;
	}
	
	private boolean validateCodeVerifier(String codeVerifier, String codeChallenge, 
			String codeChallengeMethod) {
		
		String generatedCodeChallenge = null;
		
		if ("plain".equalsIgnoreCase(codeChallengeMethod)) {
			generatedCodeChallenge = codeVerifier;
		} else if ("s256".equalsIgnoreCase(codeChallengeMethod)) {
			generatedCodeChallenge = generateHashSha256(codeVerifier);
		} else {
			throw new InvalidGrantException(codeChallengeMethod + " is not a valid challenge method.");
		}
		
		return generatedCodeChallenge.equals(codeChallenge);
	}

	private static String generateHashSha256(String plainText) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] hash = messageDigest.digest(Utf8.encode(plainText));
			return Base64.encodeBase64URLSafeString(hash);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
}