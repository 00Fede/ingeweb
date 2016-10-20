package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.UsuariosDao;
import co.edu.udea.iw.dto.Usuarios;
import co.edu.udea.iw.exception.MyDaoException;

public class UsuarioDaoHibernate implements UsuariosDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Usuarios> obtener() throws MyDaoException {
		
		Session session=null;
		List<Usuarios> resultado=null;
	

		try{
			session=sessionFactory.openSession();
			
			Criteria crit=session.createCriteria(Usuarios.class);
			
			resultado=crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		
		return resultado;
	}

	@Override
	public Usuarios obtener(int cedula) throws MyDaoException {
		
		Session session;
		Usuarios resultado=null;
		
		try{
		session=sessionFactory.openSession();
		
		Criteria crit=session.createCriteria(Usuarios.class).add(Restrictions.eq("Cedula", cedula));
		resultado=(Usuarios)crit.uniqueResult();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;
	}

	@Override
	public void guardar(Usuarios usuario) throws MyDaoException {
		Session session = null;
		Transaction tx = null;


		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(usuario);
			tx.commit();

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

	@Override
	public void modificar(Usuarios usuario) throws MyDaoException {
		Session session = null;
		Transaction tx = null;


		try {
			session = session = sessionFactory.openSession();
			//Actualiza el objeto ciudad en la base de datos
			tx = session.beginTransaction();
			session.update(usuario);
			tx.commit();

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

	@Override
	public void eliminar(int cedula) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		Usuarios usuario = new Usuarios();
		usuario.setCedula(cedula);


		try {
			
			session = session = sessionFactory.openSession();
			//elimina el objeto ciudad en la base de datos
			//Solo busca por clave primaria.
			tx = session.beginTransaction();
			session.delete(usuario);
			tx.commit();

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}

	}

}
