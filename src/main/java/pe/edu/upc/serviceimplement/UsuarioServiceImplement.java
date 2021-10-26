package pe.edu.upc.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.repositories.IUsuarioRepository;
import pe.edu.upc.serviceinterface.IUsuarioService;

@Service
public class UsuarioServiceImplement implements IUsuarioService 
{
	@Autowired
	private IUsuarioRepository cR;
	
	@Override
	public Integer insert(Usuario Usuario) 
	{
		int rpta= cR.UsuariosExistentes(Usuario.getNameUsuario());
		if(rpta==0) 
		{
			cR.save(Usuario);
		}
		return rpta;
	}

	@Override
	public List<Usuario> list() 
	{
		return cR.findAll();
	}
}