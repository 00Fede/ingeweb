/**
 * 
 */
package co.udea.edu.iw.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase tipo POJO que contiene los atributos necesarios para
 * obtener el servicio obtenerTodos()
 * @author Federico
 *
 */

@XmlRootElement //Para convertir este DTO con Jersey a JSON o XML 
public class ClienteWs {
	
	
	private String name;
	private String apellidos;
	private String identificacion;
	private String email;
	
	/**
	 * Constructor por defecto para inyeccion de spring
	 */
	public ClienteWs(){
	}
	
	public ClienteWs(String name, String apellidos, String identificacion, String email) {
		super();
		this.name = name;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.email = email;
	}
	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}
	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	/**
	 * @return the nombres
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setName(String names) {
		this.name = names;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
