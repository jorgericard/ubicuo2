package pe.edu.upc.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import pe.edu.upc.entities.Contacto;
import pe.edu.upc.repositories.IContactoRepository;
import pe.edu.upc.serviceinterface.IContactoService;

@Service
public class ContactoServiceImplement implements IContactoService{

	@Autowired
	private IContactoRepository cR;
	
	@Override
	public boolean insert(Contacto contacto) {
		// TODO Auto-generated method stub
		Contacto objContacto = cR.save(contacto);
		if (objContacto == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Contacto> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	@Transactional
	public Contacto listarId(int idContacto) {
		// TODO Auto-generated method stub
		Optional<Contacto> op = cR.findById(idContacto);
		return op.isPresent() ? op.get() : new Contacto();
	}


}
