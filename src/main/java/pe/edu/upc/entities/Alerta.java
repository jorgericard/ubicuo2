package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alertas")
public class Alerta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlerta;
	
	@ManyToOne
	@JoinColumn(name = "cEstados", nullable = true)
	private Estados cEstados;
	
	@ManyToOne
	@JoinColumn(name = "idUsuarioAux", nullable = true)
	private Usuario idUsuarioAux;
	
	@ManyToOne
	@JoinColumn(name = "idUsuarioRes", nullable = true)
	private Usuario idUsuarioRes;

	private Date fecha;

	public Alerta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alerta(int idAlerta, Estados cEstados, Usuario idUsuarioAux, Usuario idUsuarioRes, Date fecha) {
		super();
		this.idAlerta = idAlerta;
		this.cEstados = cEstados;
		this.idUsuarioAux = idUsuarioAux;
		this.idUsuarioRes = idUsuarioRes;
		this.fecha = fecha;
	}

	public int getIdAlerta() {
		return idAlerta;
	}

	public void setIdAlerta(int idAlerta) {
		this.idAlerta = idAlerta;
	}

	public Estados getcEstados() {
		return cEstados;
	}

	public void setcEstados(Estados cEstados) {
		this.cEstados = cEstados;
	}

	public Usuario getIdUsuarioAux() {
		return idUsuarioAux;
	}

	public void setIdUsuarioAux(Usuario idUsuarioAux) {
		this.idUsuarioAux = idUsuarioAux;
	}

	public Usuario getIdUsuarioRes() {
		return idUsuarioRes;
	}

	public void setIdUsuarioRes(Usuario idUsuarioRes) {
		this.idUsuarioRes = idUsuarioRes;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

		
}
