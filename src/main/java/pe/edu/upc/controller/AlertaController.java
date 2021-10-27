package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Alerta;
import pe.edu.upc.serviceinterface.IAlertaService;
import pe.edu.upc.serviceinterface.IEstadosService;
import pe.edu.upc.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/alertas")
public class AlertaController {

	@Autowired
	private IAlertaService aS;

	@Autowired
	private IEstadosService eS;

	@Autowired
	private IUsuarioService uSaux;

	@Autowired
	private IUsuarioService uSres;

	@GetMapping("/new")
	public String newAlerta(Model model) {
		model.addAttribute("alerta", new Alerta());
		model.addAttribute("listaAlertas", aS.list());
		model.addAttribute("listaEstados", eS.list());
		model.addAttribute("listaUsuariosAux", uSaux.list());
		model.addAttribute("listaUsuariosRes", uSres.list());
		model.addAttribute("alerta", new Alerta());
		return "alerta/alerta";
	}

	@GetMapping("/list")
	public String listAlertas(Model model) {
		try {
			model.addAttribute("alerta", new Alerta());
			model.addAttribute("listaAlertas", aS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "alerta/listAlertas";
	}

	@PostMapping("/save")
	public String saveAlerta(@ModelAttribute("alerta") @Valid Alerta alerta, BindingResult result, Model model, SessionStatus status) 
		throws Exception {
		if (result.hasErrors()) {
			return "alerta/alerta";
		} else {
			int rpta = aS.insert(alerta);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "alerta/alerta";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("alerta", new Alerta());
		return "redirect:/alertas/list";
	}

}
