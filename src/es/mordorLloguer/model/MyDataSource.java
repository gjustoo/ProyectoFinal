package es.mordorLloguer.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import es.mordorLloguer.config.MyConfig;
import oracle.jdbc.datasource.impl.OracleDataSource;

 
public class MyDataSource {
	
	private static String defaultProperties="db.properties";
	
	
	public static DataSource getOracleDataSource() {
		OracleDataSource ds=null;
		
	
			
			try {
				
				ds= new OracleDataSource();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ds.setURL(MyConfig.getInstancia().getOracleURL());
			ds.setUser(MyConfig.getInstancia().getOracleUsername());
			ds.setPassword(MyConfig.getInstancia().getOraclePassword());
			

		
		
		return ds;
	}
}
