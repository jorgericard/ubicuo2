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

import pe.edu.upc.entities.Distrito;
import pe.edu.upc.serviceinterface.IDistritoService;

@Controller
@RequestMapping("/distritos")
public class DistritoController {

	@Autowired
	private IDistritoService dS;
	
	@GetMapping("/new")
	public String newDistrito(Model model) {
		model.addAttribute("distrito", new Distrito());
		return "distrito/distrito";
	}
	@GetMapping("/list")
	public String listDistritos(Model model) {
		try {
			model.addAttribute("distrito", new Distrito());
			model.addAttribute("listaDistritos", dS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "distrito/listDistritos";
	}
	@PostMapping("/save")
	public String saveMarca(@Valid Distrito distrito, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "distrito/distrito";
		} else {
			int rpta = dS.insert(distrito);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe, ingrese un nuevo distrito");
				return "distrito/distrito";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("distrito", new Distrito());
		return "redirect:/distritos/list";
	}
}
