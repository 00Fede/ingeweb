package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.udea.dto.Ciudad;
import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dao.Datasource;
import co.edu.udea.iw.exception.ClaseExceptionDao;

public class CiudadDaoImpl implements CiudadDao{
	/**
	 * Entrega la lista de ciudades que tiene el sistema
	 * ordenadas por nombre
	 * @return Lista de ciudades
	 * @throws ClaseExceptionDao cuando hay un error consultado la BD
	 */
	@Override
	
	public List<Ciudad> obtener() throws ClaseExceptionDao{
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ciudad> resultado = new ArrayList<Ciudad>();
		
		try {
			c = Datasource.getInstance().getConnection();
			ps = c.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getInt("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				resultado.add(ciudad);
				
			}
		}catch(SQLException e){
			throw new ClaseExceptionDao(e);
		}finally {
			//Se cierran todas las conexiones solo si no son nulas
			try {
				if(rs != null)
					rs.close();	
				
				if(ps!=null)
					ps.close();
				
				if(c != null)
					c.close();
			} catch (SQLException e2) {
			throw new ClaseExceptionDao(e2);					
			}
		}
		return resultado;
	}
	
	@Override
	public Ciudad obtenerCiudad(Integer codigo) throws ClaseExceptionDao{
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Ciudad resultado = new Ciudad();
		
		try {
			c = Datasource.getInstance().getConnection();
			//meter en ps param codigo puede provocar sql injection
			ps = c.prepareStatement("SELECT * FROM ciudades "
					+ "WHERE codigo = ?");
			//esto evita el sqlinjection
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			
			if(rs.next()){
			resultado.setCodigo(rs.getInt("Codigo"));
			resultado.setNombre(rs.getString("Nombre"));
			resultado.setCodigoArea(rs.getString("CodigoArea"));
			}
		}catch(SQLException e){
			throw new ClaseExceptionDao(e);
		}finally {
			//Se cierran todas las conexiones solo si no son nulas
			try {
				if(rs != null)
					rs.close();	
				
				if(ps!=null)
					ps.close();
				
				if(c != null)
					c.close();
			} catch (SQLException e2) {
			throw new ClaseExceptionDao(e2);					
			}
		}
		return resultado;
		
	}
	@Override 
	public void guardar(Ciudad ciudad) throws ClaseExceptionDao{
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = Datasource.getInstance().getConnection();
			//meter en ps param codigo puede provocar sql injection
			ps = c.prepareStatement("INSERT INTO ciudades (codigo, Nombre,CodigoArea) VALUES(?,?,?)");
			//esto evita el sqlinjection
			ps.setInt(1, ciudad.getCodigo());
			ps.setString(2, ciudad.getNombre());
			ps.setString(3, ciudad.getCodigoArea());
			
			ps.execute();
			
		}catch(SQLException e){
			throw new ClaseExceptionDao(e);
		}finally {
			//Se cierran todas las conexiones solo si no son nulas
			try {	
				if(ps!=null)
					ps.close();
				
				if(c != null)
					c.close();
			} catch (SQLException e2) {
			throw new ClaseExceptionDao(e2);					
			}
		}
		
		
	}

}
