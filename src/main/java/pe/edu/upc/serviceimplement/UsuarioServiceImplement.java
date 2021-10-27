package pe.edu.upc.serviceimplement;

import java.util.List;
import java.util.Optional;


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
	public boolean insert(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario objUsuario= cR.save(usuario);
		if (objUsuario==null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<Usuario> list() 
	{
		return cR.findAll();
	}

	

	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Usuario listarId(int idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> op=cR.findById(idUsuario);
		return op.isPresent() ? op.get() : new Usuario();
	}
}