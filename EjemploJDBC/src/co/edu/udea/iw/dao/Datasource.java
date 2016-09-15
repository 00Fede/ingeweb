package co.edu.udea.iw.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import co.edu.udea.iw.exception.ClaseExceptionDao;

/**
 * 
 * Fuente de conexión para accedes a la base de datos
 * @author federico.ocampoo
 *
 */

public class Datasource {
	
	//Condiciones para clase singleton
	private static Datasource instancia;
	
	
	private Datasource(){
	}
	
	public static Datasource getInstance(){
		if (instancia==null)
			instancia = new Datasource();
		
		return instancia;
	}
	
	//hasta aqui condiciones para hacer singleton
	
	public Connection getConnection() throws SQLException, ClaseExceptionDao{
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/federico",
					"root",
					"root");
		}catch(ClassNotFoundException e){
			throw new ClaseExceptionDao("No se encontro el driver de la base de datos.");
		}catch (SQLException e) {
			throw new ClaseExceptionDao(e);
		}
		return connection;
		
	}
	
	
	
}
