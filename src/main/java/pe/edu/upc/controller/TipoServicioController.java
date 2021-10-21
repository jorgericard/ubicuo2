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

import pe.edu.upc.entities.TipoServicio;
import pe.edu.upc.serviceinterface.ITipoServicioService;

@Controller
@RequestMapping("/tiposervicios")
public class TipoServicioController {

	@Autowired
	private ITipoServicioService tS;
	
	@GetMapping("/new")
	public String newTipoServicio(Model model) {
		model.addAttribute("tiposervicio", new TipoServicio());
		return "tiposervicio/tiposervicio";
	}
	
	@GetMapping("/list")
	public String listTipoServicios(Model model) {
		try {
			model.addAttribute("tiposervicio", new TipoServicio());
			model.addAttribute("listaTipoServicios", tS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "tiposervicio/listTipoServicios";
	}
	
	@PostMapping("/save")
	public String saveTipoServicio(@Valid TipoServicio tiposervicio, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "tiposervicio/tiposervicio";
		} else {
			int rpta = tS.insert(tiposervicio);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "tiposervicio/tiposervicio";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("tiposervicio", new TipoServicio());
		return "redirect:/tiposervicios/list";
	}
}
