package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.dto.Ciudad;
import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.exception.ClaseExceptionDao;

public class CiudadDaoImplTest {
	
	@Test
	public void testObtener(){
		CiudadDao ciudadDao = null;
		List<Ciudad> ciudades = null;
		
		try{
			ciudadDao = new CiudadDaoImpl();	
			ciudades = ciudadDao.obtener();
			
			//Establece si la prueba fue satisfactoria
			assertTrue(ciudades.size()>0);
		}catch(ClaseExceptionDao e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerCiudad(){
		CiudadDao ciudadDao = null;
		Ciudad ciudad = null;
		
		try{
			ciudadDao = new CiudadDaoImpl();	
			ciudad = ciudadDao.obtenerCiudad(1);
			
			//Establece si la prueba fue satisfactoria
			assertTrue(ciudad!=null);
		}catch(ClaseExceptionDao e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardarCiudad(){
		CiudadDao ciudadDao = null;
		Ciudad ciudad = null;
		
		try{
			
			ciudad = new Ciudad();
			ciudad.setCodigo(12);
			ciudad.setNombre("Venecia");
			ciudad.setCodigoArea("071");
			
			ciudadDao = new CiudadDaoImpl();	
			ciudadDao.guardar(ciudad);		
			//Establece si la prueba fue satisfactoria
			assertTrue(true);
		}catch(ClaseExceptionDao e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
