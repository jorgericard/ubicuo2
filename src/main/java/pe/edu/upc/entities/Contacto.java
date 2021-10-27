package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contactos")
public class Contacto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContacto;
	
	@Column(name = "foto", nullable = true)
	private String photoContacto;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	@Column(name="nameContacto", length=60, nullable=false)
	private String nameContacto;
	
	@Column(name = "numeroCelular", length=9, nullable = false)
	private String numeroCelular;

	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contacto(int idContacto, Usuario usuario, String nameContacto, String numeroCelular) {
		super();
		this.idContacto = idContacto;
		this.usuario = usuario;
		this.nameContacto = nameContacto;
		this.numeroCelular = numeroCelular;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNameContacto() {
		return nameContacto;
	}

	public void setNameContacto(String nameContacto) {
		this.nameContacto = nameContacto;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getPhotoContacto() {
		return photoContacto;
	}

	public void setPhotoContacto(String photoContacto) {
		this.photoContacto = photoContacto;
	}
	
}
