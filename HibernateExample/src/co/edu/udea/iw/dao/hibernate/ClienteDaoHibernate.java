package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dao.Datasource;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

public class ClienteDaoHibernate implements ClienteDao {

	@Override
	public List<Cliente> obtener() throws MyDaoException {
		Session session = null;

		List<Cliente> resultado = null;

		try {
			session = Datasource.getInstance().getSession();

			// El criteria se basa en la clase entrada como arg
			Criteria crit = session.createCriteria(Cliente.class);

			resultado = crit.list();
		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

		return resultado;
	}

	@Override
	public Cliente obtener(String cedula) throws MyDaoException {
		Session session = null;

		Cliente cliente = null;

		try {
			session = Datasource.getInstance().getSession();

			cliente = (Cliente) session.get(Cliente.class,cedula);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}
		return cliente;
	}

	@Override
	public void guardar(Cliente cliente) throws MyDaoException {
		Session session = null;


		try {
			session = Datasource.getInstance().getSession();
			//guarda el objeto cliente en la base de datos
			session.save(cliente);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

	@Override
	public void eliminar(String cedula) throws MyDaoException {
		Session session = null;
		
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);


		try {
			session = Datasource.getInstance().getSession();
			//elimina el objeto ciudad en la base de datos
			//Solo busca por clave primaria.
			session.delete(cliente);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}
	}

	@Override
	public void modificar(Cliente cliente) throws MyDaoException {
		Session session = null;


		try {
			session = Datasource.getInstance().getSession();
			//Actualiza el objeto cliente en la base de datos
			session.update(cliente);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

}
