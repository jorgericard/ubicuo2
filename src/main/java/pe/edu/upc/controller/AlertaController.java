package pe.edu.upc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
    }

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
			model.addAttribute("listaEstados", eS.list());
			model.addAttribute("listaUsuariosAux", uSaux.list());
			model.addAttribute("listaUsuariosRes", uSres.list());
			return "alerta/alerta";
		} else {
			int rpta = aS.insert(alerta);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe, ingrese una nueva alerta");
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
