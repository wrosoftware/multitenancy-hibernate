package com.deviniti.multitenancy.separate.schema.configuration.hibernate.multitenancy;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.deviniti.multitenancy.separate.schema.security.domain.SecurityDomain;
import com.deviniti.multitenancy.separate.schema.tenant.domain.TenantDomain;
import com.deviniti.multitenancy.separate.schema.tenant.model.TenantDto;

@Component
public class TenantRequestInterceptor implements AsyncHandlerInterceptor{
	
	private SecurityDomain securityDomain;
	private TenantDomain tenantDomain;
	
	public TenantRequestInterceptor(SecurityDomain securityDomain, TenantDomain tenantDomain) {
		this.securityDomain = securityDomain;
		this.tenantDomain = tenantDomain;
	}

	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		 return Optional.ofNullable(request)
				 .map(req -> securityDomain.getTenantIdFromJwt(req))
				 .map(tenantId -> tenantDomain.getTenantByTenantId(tenantId))
				 .map(tenant -> setTenantContext(tenant))
				 .orElse(false);
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
	        TenantContext.clear();
	    }
	    
	    private boolean setTenantContext(TenantDto tenant) {
	    	System.out.println(tenant.getTenantId()+"\t"+tenant.getDatabaseSchemaName());
	    	TenantContext.setCurrentTenant(tenant);
	    	return true;
	    }
}
