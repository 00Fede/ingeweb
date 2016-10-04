package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Este dto que representa la clave compuesta de la tabla direccion
 * debe ser serializable para ser mas eficiente
 * @author federico.ocampoo
 *
 */
public class DireccionId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private Integer codigo;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
