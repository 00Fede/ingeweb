package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

public class CiudadDaoHibernate implements CiudadDao {

	private SessionFactory sessionFactory;

	@Override
	public List<Ciudad> obtener() throws MyDaoException {
		Session session = null;

		List<Ciudad> resultado = null;

		try {
			session = getSessionFactory().openSession();

			// El criteria se basa en la clase entrada como arg
			Criteria crit = session.createCriteria(Ciudad.class);

			resultado = crit.list();
		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

		return resultado;
	}

	@Override
	public Ciudad obtener(Long codigo) throws MyDaoException {
		Session session = null;

		Ciudad ciudad = null;

		try {
			
			session = getSessionFactory().openSession();

			ciudad = (Ciudad) session.get(Ciudad.class, codigo);

		} catch (HibernateException e) {
			throw new MyDaoException(e);
		}
		return ciudad;
	}

	@Override
	public void guardar(Ciudad ciudad) throws MyDaoException {
		Session session = null;
		Transaction tx = null;

		try {
			session = getSessionFactory().openSession();
			// guarda el objeto ciudad en la base de datos
			tx = session.beginTransaction();
			session.save(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

	@Override
	public void modificar(Ciudad ciudad) throws MyDaoException {
		Session session = null;
		Transaction tx = null;

		try {
			session = getSessionFactory().openSession();
			// Actualiza el objeto ciudad en la base de datos
			tx = session.beginTransaction();
			session.update(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

	@Override
	public void eliminar(Long codigo) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(codigo);

		try {
			session = getSessionFactory().openSession();
			// elimina el objeto ciudad en la base de datos
			// Solo busca por clave primaria.
			tx = session.beginTransaction();
			session.delete(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
