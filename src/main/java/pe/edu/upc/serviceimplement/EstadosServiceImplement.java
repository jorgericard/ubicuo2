package pe.edu.upc.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Estados;
import pe.edu.upc.repositories.IEstadosRepository;
import pe.edu.upc.serviceinterface.IEstadosService;

@Service
public class EstadosServiceImplement implements IEstadosService{
	
	@Autowired
	private IEstadosRepository cR;
	
	@Override
	public Integer insert(Estados estados) {
		// TODO Auto-generated method stub
		int rpta=cR.categoriasExistentes(estados.getNameEstados());
		if(rpta==0) {
			cR.save(estados);
		}
		return rpta;
	}

	@Override
	public List<Estados> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
