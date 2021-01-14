package com.deviniti.multitenancy.separate.schema.tenant.domain;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.deviniti.multitenancy.separate.schema.tenant.model.TenantDto;

@Service
@Transactional
public class TenantService {

	private TenantRepository tenantRepository;
	
	public TenantService(TenantRepository tenantRepository) {
		this.tenantRepository = tenantRepository;
	}
	
	public TenantDto findByTenantId(String tenantId) {
		return tenantRepository.findById(tenantId)
				.map(TenantMapper::mapToDto)
				.orElse(null);
	}
}
