package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import co.edu.udea.iw.dao.Datasource;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

public class UsuarioDaoHibernate implements UsuarioDao {

	@Override
	public List<Usuario> obtener() throws MyDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		
		List<Usuario> resultado = null;
		
		try {
			session = Datasource.getInstance().getSession();

			// El criteria se basa en la clase entrada como arg
			Criteria crit = session.createCriteria(Usuario.class);

			resultado = crit.list();
		} catch (Exception e) {
			throw new MyDaoException(e);
		}
		
		return resultado;
	}

}
