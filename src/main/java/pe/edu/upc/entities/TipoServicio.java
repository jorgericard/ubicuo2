package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tiposervicio")
public class TipoServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoServicio;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del Tipo de Servicio no puede contener caracteres especiales")
	@Pattern(regexp = "[^0-9]+", message = "El nombre del Tipo de Servicio no puede contener un número")
	@Column(name = "nameTipoServicio", length = 35, nullable = false)
	private String nameTipoServicio;

	public TipoServicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoServicio(int idTipoServicio, String nameTipoServicio) {
		super();
		this.idTipoServicio = idTipoServicio;
		this.nameTipoServicio = nameTipoServicio;
	}

	public int getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(int idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public String getNameTipoServicio() {
		return nameTipoServicio;
	}

	public void setNameTipoServicio(String nameTipoServicio) {
		this.nameTipoServicio = nameTipoServicio;
	}
	
	
}
