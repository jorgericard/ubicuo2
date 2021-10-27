package pe.edu.upc.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Alerta;
import pe.edu.upc.repositories.IAlertaRepository;
import pe.edu.upc.serviceinterface.IAlertaService;

@Service
public class AlertaServiceImplement implements IAlertaService {

	@Autowired
	private IAlertaRepository aR;

	@Override
	public Integer insert(Alerta alerta) {
		// TODO Auto-generated method stub
		int rpta= aR.buscarAlerta(alerta.getIdAlerta());
		if(rpta==0) 
		{
			aR.save(alerta);
		}
		return rpta;
	}

	@Override
	public List<Alerta> list() {
		// TODO Auto-generated method stub
		return aR.findAll();
	}
	
}
