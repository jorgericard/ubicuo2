package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ubicaciones")
public class Ubicacion {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idUbicacion;
	
	
	@Column(name="nlongitud", length =35, nullable=false)
	private int nlongitud;
	
	@Column(name="nlatitud", length =35, nullable=false)
	private int nlatitud;

	public Ubicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Ubicacion(int idUbicacion, int nlongitud, int nlatitud) {
		super();
		this.idUbicacion = idUbicacion;
		this.nlongitud = nlongitud;
		this.nlatitud = nlatitud;
	}
	public int getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public int getNlongitud() {
		return nlongitud;
	}

	public void setNlongitud(int nlongitud) {
		this.nlongitud = nlongitud;
	}

	public int getNlatitud() {
		return nlatitud;
	}

	public void setNlatitud(int nlatitud) {
		this.nlatitud = nlatitud;
	}

	
	
}
