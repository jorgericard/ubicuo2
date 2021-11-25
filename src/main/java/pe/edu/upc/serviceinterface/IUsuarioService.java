package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioService 
{
	public Integer insert(Usuario Usuario);
	
	public void delete(int idUsuario);
	
	Optional <Usuario> listId(int idusuario);
	
	List<Usuario> list();
	
	Usuario listarId(int idUsuario);
}