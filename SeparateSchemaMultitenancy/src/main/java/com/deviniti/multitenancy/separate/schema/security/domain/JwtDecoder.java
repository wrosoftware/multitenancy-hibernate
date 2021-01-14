package com.deviniti.multitenancy.separate.schema.security.domain;

import java.text.ParseException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.deviniti.multitenancy.separate.schema.security.model.JwtClaim;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;


public class JwtDecoder {
	private static final String AUTHORIZATION = "Authorization";
	private static final String BEARER = "Bearer";
	
	private final String jwtToken;
	
	public JwtDecoder(HttpServletRequest request) {
			this.jwtToken = Optional.ofNullable(request)
					.map(req -> req.getHeader(AUTHORIZATION))
					.filter(headerWithToken -> headerWithToken.startsWith(BEARER))
	    			.map(headerWithToken -> headerWithToken.substring(BEARER.length()))
	    			.map(token -> token.trim())
	                .orElseThrow(() -> {
	                    return new CredentialsException("Missing Authentication Token");
	                });
	}
	
	
	public String getJwtParameter(JwtClaim jwtClaim) {
		return Optional.ofNullable(getSignedJWT())
				.map(this::getJWTClaimsSet)
				.map(JWTClaimsSet::getClaims)
				.map(stringObjectMap -> stringObjectMap.get(jwtClaim.getValue()))
				.map(Object::toString)
				.orElse(null);
	}
	
	private SignedJWT getSignedJWT() {
		 try {
			return SignedJWT.parse(jwtToken);
		} catch (ParseException e) {
			throw new CredentialsException("Cannot parse jwt token");
		}
			
	}
	
	private JWTClaimsSet getJWTClaimsSet(SignedJWT signedJWT) {
		try {
			return signedJWT.getJWTClaimsSet();
		} catch (ParseException e) {
			throw new CredentialsException("Canot exctract Claim Set from jwt token");
		}
	}
	
}
