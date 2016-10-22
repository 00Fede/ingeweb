package co.edu.udea.iw.dao.hibernate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dao.hibernate.CiudadDaoHibernate;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyDaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"spring_config.xml"})

public class CiudadDaoHibernateTest {
	
	@Autowired
	CiudadDao dao;

	@Test
	public void testObtener() {
		CiudadDao ciudadDao = new CiudadDaoHibernate();
		
		List<Ciudad> ciudades;
		
		try{
			ciudades = ciudadDao.obtener();
			assertTrue(ciudades.size() > 0);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
