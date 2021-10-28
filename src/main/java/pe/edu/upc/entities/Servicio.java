package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="servicios")
public class Servicio {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idServicio;
	

	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del servicio no puede contener un número")
	@Pattern(regexp = "[^0-9]+", message = "El nombre del servicio no puede contener un número")
	@Column(name = "nameServicio", nullable = false)
	private String nameServicio;
	
	@Column(name="direccionServicio",nullable=false, length=60)
	private String direccionServicio;
	
	@Column(name="numtelef",nullable=false, length=60)
	private int numtelef;
	
	@ManyToOne
	@NotNull(message = "Seleccione un Distrito")
	@JoinColumn(name = "idDistrito", nullable = false)
	private Distrito distrito;

	@ManyToOne
	@NotNull(message = "Seleccione un Tipo de Servicio")
	@JoinColumn(name = "idTipoServicio", nullable = false)
	private TipoServicio tipoServicio;
	
	

	public Servicio(int idServicio,String nameServicio,
			String direccionServicio, int numtelef,Distrito distrito, TipoServicio tipoServicio) {
		super();
		this.idServicio = idServicio;
		
		this.nameServicio = nameServicio;
		this.direccionServicio = direccionServicio;
		this.numtelef=numtelef;
		this.distrito = distrito;
		this.tipoServicio = tipoServicio;
	}
	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	

	public String getNameServicio() {
		return nameServicio;
	}

	public void setNameServicio(String nameServicio) {
		this.nameServicio = nameServicio;
	}

	public String getDireccionServicio() {
		return direccionServicio;
	}

	public void setDireccionServicio(String direccionServicio) {
		this.direccionServicio = direccionServicio;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public int getNumtelef() {
		return numtelef;
	}
	public void setNumtelef(int numtelef) {
		this.numtelef = numtelef;
	}
}
