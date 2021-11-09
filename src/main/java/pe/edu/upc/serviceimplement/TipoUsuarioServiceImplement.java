package pe.edu.upc.serviceimplement;

import java.util.List;
import java.util.Optional;

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
	public Integer insert(TipoUsuario TipoUsuario) 
	{
		int rpta= cR.TipoUsuariosExistentes(TipoUsuario.getNameTipoUsuario());
		if(rpta==0) 
		{
			cR.save(TipoUsuario);
		}
		return rpta;
	}

	@Override
	public List<TipoUsuario> list() 
	{
		return cR.findAll();
	}
	
	@Override
	public void delete(int cTipoUsuario) {
		// TODO Auto-generated method stub
		cR.deleteById(cTipoUsuario);
	}

	@Override
	public Optional<TipoUsuario> listId(int cTipoUsuario) {
		// TODO Auto-generated method stub
		return cR.findById(cTipoUsuario);
	}
	
}
