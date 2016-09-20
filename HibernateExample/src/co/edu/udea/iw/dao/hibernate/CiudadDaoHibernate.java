package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dao.Datasource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyDaoException;

public class CiudadDaoHibernate implements CiudadDao {

	@Override
	public List<Ciudad> obtener() throws MyDaoException {
		// TODO Auto-generated method stub
		Session session = null;

		List<Ciudad> resultado = null;

		try {
			session = Datasource.getInstance().getSession();

			// El criteria se basa en la clase entrada como arg
			Criteria crit = session.createCriteria(Ciudad.class);

			resultado = crit.list();
		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

		return resultado;
	}

}
