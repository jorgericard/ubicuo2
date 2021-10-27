package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioService 
{
	public boolean insert(Usuario Usuario);
	
	List<Usuario> list();
	Usuario listarId(int idUsuario);
}