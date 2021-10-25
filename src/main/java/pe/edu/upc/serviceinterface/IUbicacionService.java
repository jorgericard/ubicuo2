package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Ubicacion;

public interface IUbicacionService {
	
	public Integer insert(Ubicacion ubicacion);
	
	List<Ubicacion> list();
}
