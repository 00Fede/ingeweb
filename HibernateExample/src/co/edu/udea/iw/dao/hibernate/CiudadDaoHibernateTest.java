package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyDaoException;

public class CiudadDaoHibernateTest {

	@Test
	public void testObtener() {
		CiudadDao ciudadDao = new CiudadDaoHibernate();
		
		List<Ciudad> ciudades;
		
		try{
			ciudades = ciudadDao.obtener();
			assertTrue(ciudades.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}
	}

}
