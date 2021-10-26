package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Usuario")
public class Usuario 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idUsuario;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del Usuario no puede contener un número")
	@Pattern(regexp = "[^0-9]+", message = "El nombre del Usuario no puede contener un número")
	@Column(name = "nameUsuario", length = 35, nullable = false)
	private String nameUsuario;

	public Usuario() 
	{
		super();
	}

	public Usuario(int idUsuario, String nameUsuario) 
	{
		super();
		this.idUsuario = idUsuario;
		this.nameUsuario = nameUsuario;
	}

	public int getIdUsuario() 
	{
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) 
	{
		this.idUsuario = idUsuario;
	}

	public String getNameUsuario() 
	{
		return nameUsuario;
	}
	public void setNameUsuario(String nameUsuario) 
	{
		this.nameUsuario = nameUsuario;
	}
	
}