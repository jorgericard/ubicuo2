package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estados {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cEstados;
	
	@Column(name="nameEstados", length=35, nullable=false)
	private String nnombreestados;

	public Estados() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estados(int cEstados, String nnombreestados) {
		super();
		this.cEstados = cEstados;
		this.nnombreestados = nnombreestados;
	}

	public int getcEstados() {
		return cEstados;
	}

	public void setcEstados(int cEstados) {
		this.cEstados = cEstados;
	}

	public String getNnombreestados() {
		return nnombreestados;
	}

	public void setNnombreestados(String nnombreestados) {
		this.nnombreestados = nnombreestados;
	}
}
