package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.TipoUsuario;

public interface ITipoUsuarioService 
{
	public void insert(TipoUsuario TipoUsuario);
	
	List<TipoUsuario> list();
}