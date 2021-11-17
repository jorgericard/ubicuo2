package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioService 
{
	public Integer insert(Usuario Usuario);
	
	public void delete(Long idUsuario);
	
	List<Usuario> list();
}