package pe.edu.upc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="TipoUsuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "usuario_id", "nameTipoUsuario" }) })
public class TipoUsuario implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTipoUsuario;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del TipoUsuario no puede contener un número")
	@Pattern(regexp = "[^0-9]+", message = "El nombre del TipoUsuario no puede contener un número")
	@Column(name = "nameTipoUsuario", length = 35, nullable = false)
	private String nameTipoUsuario;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNameTipoUsuario() {
		return nameTipoUsuario;
	}

	public void setNameTipoUsuario(String nameTipoUsuario) {
		this.nameTipoUsuario = nameTipoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
