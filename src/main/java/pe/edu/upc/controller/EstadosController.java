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

import pe.edu.upc.entities.Estados;
import pe.edu.upc.serviceinterface.IEstadosService;

@Controller
@RequestMapping("/estadoss")
public class EstadosController {
	@Autowired
	private IEstadosService cService;
	
	@GetMapping("/new")
	public String newEstados(Model model) {
		model.addAttribute("estados", new Estados());
		return "estados/estados";
	}
	
	@GetMapping("/list")
	public String listEstados(Model model) {
		try {
			model.addAttribute("estados", new Estados());
			model.addAttribute("listaEstados", cService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "estados/listEstados";
	}
	
	@PostMapping("/save")
	public String saveMarca(@Valid Estados estados, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "estados/estados";
		} else {
			int rpta = cService.insert(estados);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "estados/estados";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("estados", new Estados());
		return "redirect:/estadoss/list";
	}

}
