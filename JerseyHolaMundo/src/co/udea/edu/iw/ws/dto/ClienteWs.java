/**
 * 
 */
package co.udea.edu.iw.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase tipo POJO que contiene los atributos necesarios para
 * obtener el servicio obtenerTodos()
 * @author Federico
 *
 */

@XmlRootElement //Para convertir este DTO con Jersey a JSON o XML 
public class ClienteWs {
	
	
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String email;
	
	
	public ClienteWs(String nombres, String apellidos, String identificacion, String email) {
		super();
		this.nombres = nombres;
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
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
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
