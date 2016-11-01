/**
 * 
 */
package co.udea.edu.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.UsuarioBl;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * @author Federico
 *
 */
@Path("ServicioUsuario")
@Component
public class ServicioUsuario {
	
	@Autowired
	UsuarioBl usuarioBl;

	/**
	 * @return the usuarioBl
	 */
	public UsuarioBl getUsuarioBl() {
		return usuarioBl;
	}

	/**
	 * @param usuarioBl the usuarioBl to set
	 */
	public void setUsuarioBl(UsuarioBl usuarioBl) {
		this.usuarioBl = usuarioBl;
	}
	/**
	 * Servicio del Login del usuario
	 * @Param id : id de usuario
	 * @pass pass : Password del usuario
	 * */
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("login")
	public String login(@QueryParam("id")String id,
			@QueryParam("password")String pass) throws MyDaoException{
		if(pass==null||id==null||"".equals(id.trim())||"".equals(pass.trim())){
			return "Ingrese todos los campos de registro";
		}
		if(usuarioBl.login(id, pass)){
			return "Registro Exitoso";
		}
		return "Los datos de sesion no son correctos";
	}

}
