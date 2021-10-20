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
@RequestMapping("/estados")
public class EstadosController {
	@Autowired
	private IEstadosService cEstados;
	
	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Estados());
		return "category/category";
	}
	
	@GetMapping("/list")
	public String listEstados(Model model) {
		try {
			model.addAttribute("estados", new Estados());
			model.addAttribute("listaEstados", cEstados.list());
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
			int rpta = cEstados.insert(estados);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "estados/estados";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("estados", new Estados());
		return "redirect:/estados/list";
	}

}
