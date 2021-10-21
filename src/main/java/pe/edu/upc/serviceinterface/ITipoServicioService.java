package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.TipoServicio;

public interface ITipoServicioService {
	
	public Integer insert(TipoServicio tiposervicio);

	List<TipoServicio> list(); 
}
