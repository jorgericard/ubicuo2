package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="TipoUsuario")
public class TipoUsuario 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTipoUsuario;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del Distrito no puede contener un número")
	@Pattern(regexp = "[^0-9]+", message = "El nombre del Distrito no puede contener un número")
	@Column(name = "nameTipoUsuario", length = 35, nullable = false)
	private String nameTipoUsuario;

	public TipoUsuario() 
	{
		super();
	}

	public TipoUsuario(int idTipoUsuario, String nameTipoUsuario) 
	{
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.nameTipoUsuario = nameTipoUsuario;
	}

	public int getIdTipoUsuario() 
	{
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) 
	{
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNameTipoUsuario() 
	{
		return nameTipoUsuario;
	}
	public void setNameTipoUsuario(String nameTipoUsuario) 
	{
		this.nameTipoUsuario = nameTipoUsuario;
	}
	
}
