package co.edu.udea.iw.dao.hibernate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

public class UsuarioDaoHibernate implements UsuarioDao {

	private SessionFactory sessionFactory;

	@Override
	public List<Usuario> obtener() throws MyDaoException {
		Session session = null;
		
		List<Usuario> resultado = null;
		
		try {
			session = getSessionFactory().openSession();

			// El criteria se basa en la clase entrada como arg
			Criteria crit = session.createCriteria(Usuario.class);

			resultado = crit.list();
		} catch (Exception e) {
			throw new MyDaoException(e);
		}
		
		return resultado;
	}
	
	@Override
	public Usuario obtener(String login) throws MyDaoException {
		Session session = null;

		Usuario usuario = null;

		try {
			session = getSessionFactory().openSession();
			/**session.get es la mejor forma de retornar un registro dada su PK
			 * Si no existe el registro retorna un objeto null*/	
			usuario = (Usuario) session.get(Usuario.class,login);
		
			/**Igual que session get. Si no existe el registro lanza excepcion*/
			//usuario = (Usuario) session.load(Usuario.class,login);

		} catch (HibernateException e) {
			throw new MyDaoException(e);

		}
		return usuario;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
