package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.exception.MyDaoException;

public class Datasource {

	private static Datasource instancia;
	private SessionFactory sessionFactory = null;

	private Datasource() {

	}

	public static Datasource getInstance() {
		if (instancia == null)
			instancia = new Datasource();

		return instancia;
	}

	public Session getSession() throws MyDaoException {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration();

				// aqui se pone el archivo de configuracion de hibernate
				configuration.configure("hibernate.cfg.xml");

				sessionFactory = configuration.buildSessionFactory();
			}

			return sessionFactory.openSession();
		} catch (HibernateException e) {
			throw new MyDaoException(e);
		}
	}
}
