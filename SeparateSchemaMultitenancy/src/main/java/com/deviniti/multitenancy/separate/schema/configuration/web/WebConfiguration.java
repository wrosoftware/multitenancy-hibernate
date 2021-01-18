package com.deviniti.multitenancy.separate.schema.configuration.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.deviniti.multitenancy.separate.schema.configuration.spring.multitenancy.TenantRequestInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Autowired
    private TenantRequestInterceptor tenantInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantInterceptor).addPathPatterns("/api/**").excludePathPatterns("/swagger-ui.html");
    }
	
}
