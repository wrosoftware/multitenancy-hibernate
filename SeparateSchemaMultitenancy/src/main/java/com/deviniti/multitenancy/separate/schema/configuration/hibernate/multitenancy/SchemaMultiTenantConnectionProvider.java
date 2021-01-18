package com.deviniti.multitenancy.separate.schema.configuration.hibernate.multitenancy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.AbstractMultiTenantConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.deviniti.multitenancy.separate.schema.configuration.multitenancy.context.TenantContext;

@SuppressWarnings("serial")
public class SchemaMultiTenantConnectionProvider extends AbstractMultiTenantConnectionProvider {
	
	private final Map<String, ConnectionProvider> connectionProviderMap;

	public SchemaMultiTenantConnectionProvider() {
		this.connectionProviderMap = new HashMap<String, ConnectionProvider>();
	}
	
	@Override
	public Connection getConnection(String tenantIdentifier) throws SQLException {
		Connection connection = super.getConnection(tenantIdentifier);
		connection.createStatement().execute(String.format("SET SCHEMA '%s';", tenantIdentifier));
		return connection;
	}
	
	@Override
	protected ConnectionProvider getAnyConnectionProvider() {
		return Optional.ofNullable(getConnectionProvider(TenantContext.DEFAULT_TENANT_ID))
				.orElse(null);
	}

	@Override
	protected ConnectionProvider selectConnectionProvider(String tenantIdentifier) {
		return getConnectionProvider(tenantIdentifier);
	}
	
	private ConnectionProvider getConnectionProvider(String tenantIdentifier) {
		return Optional.ofNullable(tenantIdentifier)
				.map(connectionProviderMap::get)
				.orElseGet(() -> createNewConnectionProvider(tenantIdentifier));
	}

	private ConnectionProvider createNewConnectionProvider(String tenantIdentifier) {
		return Optional.ofNullable(tenantIdentifier)
				.map(this::createConnectionProvider)
				.map(connectionProvider -> connectionProviderMap.put(tenantIdentifier, connectionProvider))
				.orElseThrow(() -> new ConnectionProviderException("Cannot create new connection provider for tenant: "+tenantIdentifier));
	}
	
	private ConnectionProvider createConnectionProvider(String tenantIdentifier) {
		return Optional.ofNullable(TenantHelper.getInstance())
				.map(helper -> helper.getHibernatePropertiesForTenantId(tenantIdentifier))
				.map(hibernateProperties -> initConnectionProvider(hibernateProperties))
				.orElse(null);
	}

	private ConnectionProvider initConnectionProvider(Properties hibernateProperties) {
		DriverManagerConnectionProviderImpl connectionProvider = new DriverManagerConnectionProviderImpl();
		connectionProvider.configure(hibernateProperties);
		return connectionProvider;
	}
	
}
