package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


import pe.edu.upc.entities.Ubicacion;
import pe.edu.upc.serviceinterface.IUbicacionService;

@Controller
@RequestMapping("/ubicaciones")
public class UbicacionController {

	@Autowired
	private IUbicacionService uS;

	@GetMapping("/new")
	public String newUbicacion(Model model) {
		model.addAttribute("ubicacion", new Ubicacion());
		return "ubicacion/ubicacion";
	}
	@GetMapping("/list")
	public String listUbicaciones(Model model) {
		try {
			model.addAttribute("ubicacion", new Ubicacion());
			model.addAttribute("listaUbicaciones", uS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "ubicacion/listUbicaciones";
	}
	@PostMapping("/save")
	public String saveMarca(@Valid Ubicacion ubicacion, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "ubicacion/ubicacion";
		} else {
			int rpta = uS.insert(ubicacion);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe, ingrese una nueva ubicacion");
				return "ubicacion/ubicacion";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("ubicacion", new Ubicacion());
		return "redirect:/ubicaciones/list";
	}
}
