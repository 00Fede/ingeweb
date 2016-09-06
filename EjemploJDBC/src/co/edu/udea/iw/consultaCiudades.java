package co.edu.udea.iw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para consultar las ciudades
 * 
 * @author federico
 *
 */
public class consultaCiudades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;

		try {

			// Carga el driver en memoria
			// ClassNotFoundException needs to be handled
			Class.forName("com.mysql.jdbc.Driver");

			// Toma la conexion. parametros: direccion del servidor, username,
			// password
			// SqlException needs to be handled
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "clase","claseingenieriaweb");
			
			//For the table name, SQL is caps sensitive in Linux and non sensitive in Windows.
			ps = connection.prepareStatement("select * from ciudades");
			
			//All rows returned are saved in the result set
			resultSet = ps.executeQuery();
			
			//Iterate the result set
			while(resultSet.next()){
				System.out.println("/*****************************************/");
				
				//Column names are not caps sensitive, no matter the OS
				//ResultSet can get data either by index or column name
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
				System.out.println("Codigo de area: " + resultSet.getString("CodigoArea"));
				
			}
			
			
			resultSet.close();
			ps.close();
			connection.close();
			
		} catch (SQLException | ClassNotFoundException c) {
			// No se debe hacer porque imprime el error al publico
			c.printStackTrace();
		}

	}

}
