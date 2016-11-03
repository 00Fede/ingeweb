/**
 * 
 */
package co.udea.edu.iw.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.ClienteBl;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;
import co.udea.edu.iw.ws.dto.ClienteWs;

/**
 * @author estudiantelis
 *
 */
@Path("ServicioCliente")
@Component

public class ServicioCliente {
	
	

	@Autowired //para inyectar con spring
	ClienteBl clienteBl;
	
	/**
	 * @return the clienteBl
	 */
	public ClienteBl getClienteBl() {
		return clienteBl;
	}


	/**
	 * @param clienteBl the clienteBl to set
	 */
	public void setClienteBl(ClienteBl clienteBl) {
		this.clienteBl = clienteBl;
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteWs> obtener() throws RemoteException{
		List<ClienteWs> resultado = new ArrayList<>();
		List<Cliente> datos = null;
		
		try {
			datos = clienteBl.obtener();
			
			for (Cliente cliente:datos){
				ClienteWs clienteWs = new ClienteWs(cliente.getNombres(),
						cliente.getApellidos(),
						cliente.getCedula(),
						cliente.getEmail());
				
				resultado.add(clienteWs);
			}
			
			
		} catch (MyDaoException e) {
			throw new RemoteException(e.getMessage(),e);
		}
		return resultado;
	}
	
	//Puede retornar string, "" cuando se guarde, "el error" cuando haya error.
	/**
	 * Metodo utilizado ser invocado como servicio web REST que permite
	 * crear un cliente en el sistema
	 * @param cedula, cedula del usuario
	 * @param nombres, nombre del usuario
	 * @param apellidos, apellidos del usuario
	 * @param email, correo electronico del usuario
	 * @param usuario, Usuario que esta creando el usuario
	 * @throws RemoteException
	 */
	@POST
	public void guardar(@QueryParam("cedula")String cedula, 
			@QueryParam("nombres")String nombres, 
			@QueryParam("apellidos")String apellidos, 
			@QueryParam("email")String email, 
			@QueryParam("usuario")String usuario)
		throws RemoteException{
		//no se hace validación ya que se hace en capas mas bajas
		try {
			clienteBl.crearCliente(cedula, nombres, apellidos, email, usuario);
		} catch (MyDaoException e) {
			throw new RemoteException(e.getMessage());
		}
	}
	

}
