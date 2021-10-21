package pe.edu.upc.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.TipoServicio;
import pe.edu.upc.repositories.ITipoServicioRepository;
import pe.edu.upc.serviceinterface.ITipoServicioService;

@Service
public class TipoServicioServiceImplement implements ITipoServicioService{

	@Autowired
	private ITipoServicioRepository tR;
	
	@Override
	public Integer insert(TipoServicio tiposervicio) {
		// TODO Auto-generated method stub
		int rpta = tR.TipoServicioExistentes(tiposervicio.getNameTiposervicio());
		if (rpta == 0) {
			tR.save(tiposervicio);
		}
		return rpta;
	}

	@Override
	public List<TipoServicio> list() {
		// TODO Auto-generated method stub
		return tR.findAll();
	}

}
