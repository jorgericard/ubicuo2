package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Estados;

public interface IEstadosService {
	public Integer insert(Estados estados);
	List<Estados> list();

}
