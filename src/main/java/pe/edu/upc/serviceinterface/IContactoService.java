package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Contacto;

public interface IContactoService {
	
	public Integer insert(Contacto contacto);

	List<Contacto> list();

	Contacto listarId(int idContacto);

}
