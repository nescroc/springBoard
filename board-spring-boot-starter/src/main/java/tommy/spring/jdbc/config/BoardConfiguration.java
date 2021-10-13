package tommy.spring.jdbc.config;

import tommy.spring.jdbc.util.JDBCConnectionManager;

//@Configuration
public class BoardConfiguration { 
	
	
	
//	@Bean
//	@ConditionalOnMissingBean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
		manager.setUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		manager.setUsername("mytest");
		manager.setPassword("mytest");
		return manager;
	}
}
