package pe.edu.upc.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Cargo;
import pe.edu.upc.repositories.ICargoRepository;
import pe.edu.upc.serviceinterface.ICargoService;

@Service
public class CargoServiceImplement implements ICargoService
{
	@Autowired
	private ICargoRepository cR;
	
	@Override
	public Integer insert(Cargo cargo) 
	{
		int rpta= cR.cargosExistentes(cargo.getNameCargo());
		if(rpta==0) 
		{
			cR.save(cargo);
		}
		return rpta;
	}

	@Override
	public List<Cargo> list() 
	{
		return cR.findAll();
	}

}
