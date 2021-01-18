package com.deviniti.multitenancy.separate.schema.configuration.spring.multitenancy;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.deviniti.multitenancy.separate.schema.configuration.multitenancy.context.TenantContext;
import com.deviniti.multitenancy.separate.schema.security.domain.SecurityDomain;

@Component
public class TenantRequestInterceptor implements AsyncHandlerInterceptor{
	
	private SecurityDomain securityDomain;
	
	public TenantRequestInterceptor(SecurityDomain securityDomain) {
		this.securityDomain = securityDomain;
	}

	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		 return Optional.ofNullable(request)
				 .map(req -> securityDomain.getTenantIdFromJwt(req))
				 .map(tenant -> setTenantContext(tenant))
				 .orElse(false);
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
	        TenantContext.clear();
	    }
	    
	    private boolean setTenantContext(String tenant) {
	    	TenantContext.setCurrentTenant(tenant);
	    	return true;
	    }
}
