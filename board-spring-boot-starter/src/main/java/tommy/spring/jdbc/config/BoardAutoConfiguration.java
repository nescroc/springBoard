package tommy.spring.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tommy.spring.jdbc.util.JDBCConnectionManager;

@Configuration
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	
	@Autowired
	private JDBCConnectionManagerProperties properties;
	
	@Bean
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		return manager;
	}
}
