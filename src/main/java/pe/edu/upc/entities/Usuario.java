package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "nombre_apellidoUsuario", length = 35, nullable = false)
	private String nameUsuario;
	
	@Column(name = "password", length = 35, nullable = false)
	private String password;
	
	@Column(name = "correo", length = 35, nullable = false)
	private String correo;
	
	@Column(name = "dni", nullable = false)
	private int dni;
	
	@ManyToOne
	@JoinColumn(name = "idTipoUsuario", nullable = false)
	private TipoUsuario tiposusuario;
	
	@ManyToOne
	@JoinColumn(name = "idUbicacion", nullable = false)
	private Ubicacion ubicacion;
	
	@ManyToOne
	@JoinColumn(name = "idCargo", nullable = false)
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "idServicio", nullable = false)
	private Servicio servicio;

	public Usuario() 
	{
		super();
	}

	public Usuario(int idUsuario, String nameUsuario, String password, String correo, int dni, TipoUsuario tiposusuario, Ubicacion ubicacion, Cargo cargo, Servicio servicio) 
	{
		super();
		this.idUsuario = idUsuario;
		this.nameUsuario = nameUsuario;
		this.password = password;
		this.correo = correo;
		this.dni = dni;
		this.tiposusuario = tiposusuario;
		this.ubicacion = ubicacion;
		this.cargo = cargo;
		this.servicio = servicio;
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

	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getCorreo() 
	{
		return correo;
	}
	public void setCorreo(String coreo) 
	{
		this.correo = coreo;
	}

	public int getDni() 
	{
		return dni;
	}
	public void setDni(int dni) 
	{
		this.dni = dni;
	}

	public TipoUsuario getTiposusuario() 
	{
		return tiposusuario;
	}
	public void setTiposusuario(TipoUsuario tiposusuario) 
	{
		this.tiposusuario = tiposusuario;
	}

	public Ubicacion getUbicacion() 
	{
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) 
	{
		this.ubicacion = ubicacion;
	}

	public Cargo getCargo() 
	{
		return cargo;
	}
	public void setCargo(Cargo cargo) 
	{
		this.cargo = cargo;
	}

	public Servicio getServicio() 
	{
		return servicio;
	}
	public void setServicio(Servicio servicio) 
	{
		this.servicio = servicio;
	}
	
}