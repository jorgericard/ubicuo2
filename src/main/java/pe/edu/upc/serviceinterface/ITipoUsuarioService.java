package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.TipoUsuario;

public interface ITipoUsuarioService 
{
	public Integer insert(TipoUsuario TipoUsuario);
	List<TipoUsuario> list();
	public void delete(int cTipoUsuario);	
	Optional<TipoUsuario> listId(int cTipoUsuario);
}