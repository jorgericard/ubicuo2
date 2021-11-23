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

import pe.edu.upc.entities.TipoUsuario;
import pe.edu.upc.serviceinterface.IUsuarioService;
import pe.edu.upc.serviceinterface.ITipoUsuarioService;

@Controller
@RequestMapping("/tipousuarios")
public class TipoUsuarioController {
	@Autowired
	private IUsuarioService uService;
	@Autowired
	private ITipoUsuarioService cS;

	@GetMapping("/new")
	public String newtipousuario(Model model) {
		model.addAttribute("tipousuario", new TipoUsuario());
		model.addAttribute("listaUsuarios", uService.list());
		return "tipousuario/tipousuario";
	}

	@GetMapping("/list")
	public String listtipousuarios(Model model) {
		try {
			model.addAttribute("tipousuario", new TipoUsuario());
			model.addAttribute("listaTipoUsuarios", cS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "tipousuario/listTipoUsuarios";
	}

	@PostMapping("/save")
	public String saveRole(@Valid TipoUsuario tipoUsuario, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("tipousuario",tipoUsuario);
			model.addAttribute("listaUsuarios", uService.list());
			return "tipousuario/tipousuario";
		} else {
			int rpta = cS.insert(tipoUsuario);
			if (rpta > 0) {
				model.addAttribute("tipousuario",tipoUsuario);
				model.addAttribute("mensaje", "El usuario ya tiene rol");
				model.addAttribute("listaUsuarios", uService.list());
				return "tipousuario/tipousuario";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}

		model.addAttribute("tipousuario", new TipoUsuario());

		return "redirect:/tipousuarios/list";

	}

}