package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Alerta;

public interface IAlertaService {

	public Integer insert(Alerta alerta);
	
	List<Alerta> list();
}
