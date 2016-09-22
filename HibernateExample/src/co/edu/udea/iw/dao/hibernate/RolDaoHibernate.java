package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.Datasource;
import co.edu.udea.iw.dao.RolDao;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.MyDaoException;

public class RolDaoHibernate implements RolDao {

	@Override
	public List<Rol> obtener() throws MyDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		
		List<Rol> resultado = null;

		try {
			session = Datasource.getInstance().getSession();

			// El criteria se basa en la clase entrada como arg
			Criteria crit = session.createCriteria(Rol.class);

			resultado = crit.list();
		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

		return resultado;
	}

	
}
