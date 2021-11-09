package pe.edu.upc.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.TipoUsuario;
import pe.edu.upc.repositories.ITipoUsuarioRepository;
import pe.edu.upc.serviceinterface.ITipoUsuarioService;

@Service
public class TipoUsuarioServiceImplement implements ITipoUsuarioService {
	@Autowired
	private ITipoUsuarioRepository cR;
	
	@Override
	public void insert(TipoUsuario TipoUsuario) 
	{
		cR.save(TipoUsuario);
	}

	@Override
	public List<TipoUsuario> list() 
	{
		return cR.findAll();
	}
}
