package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Cargo;

public interface ICargoService 
{
	public Integer insert(Cargo cargo);
	
	List<Cargo> list();
}
