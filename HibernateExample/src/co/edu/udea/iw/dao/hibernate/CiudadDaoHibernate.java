package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

	@Override
	public Ciudad obtener(Long codigo) throws MyDaoException {
		// TODO Auto-generated method stub
		Session session = null;

		Ciudad ciudad = null;

		try {
			session = Datasource.getInstance().getSession();

			// El criteria se basa en la clase entrada como arg
			//TODO: Existen dos formas de hacer esto, consultarlas
			//
			Criteria crit = session.createCriteria(Ciudad.class).
					add(Restrictions.eq("codigo", codigo));
			
			ciudad = (Ciudad)crit.uniqueResult();

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}
		return ciudad;
	}

	@Override
	public void guardar(Ciudad ciudad) throws MyDaoException {
		// TODO Auto-generated method stub
		Session session = null;


		try {
			session = Datasource.getInstance().getSession();
			//guarda el objeto ciudad en la base de datos
			session.save(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

	@Override
	public void modificar(Ciudad ciudad) throws MyDaoException {
		// TODO Auto-generated method stub
		Session session = null;


		try {
			session = Datasource.getInstance().getSession();
			//Actualiza el objeto ciudad en la base de datos
			session.update(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

	@Override
	public void eliminar(Long codigo) throws MyDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(codigo);


		try {
			session = Datasource.getInstance().getSession();
			//elimina el objeto ciudad en la base de datos
			//Solo busca por clave primaria.
			session.delete(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

}
