package pe.edu.upc.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Estados;
import pe.edu.upc.entities.TipoUsuario;
import pe.edu.upc.serviceinterface.ITipoUsuarioService;

@Controller
@RequestMapping("/tipousuarios")
public class TipoUsuarioController 
{
	@Autowired
	private ITipoUsuarioService cS;
	
	@GetMapping("/new")
	public String newtipousuario(Model model) 
	{
		model.addAttribute("tipousuario", new TipoUsuario());
		return "tipousuario/tipousuario";
	}
	
	@GetMapping("/list")
	public String listtipousuarios(Model model) 
	{
		try 
		{
			model.addAttribute("tipousuario", new TipoUsuario());
			model.addAttribute("listaTipoUsuarios", cS.list());
		} 
		catch (Exception e) 
		{
			model.addAttribute("error", e.getMessage());
		}
		return "tipousuario/listTipoUsuarios";
	}
	
	@PostMapping("/save")
	public String saveMarca(@ModelAttribute("tipousuario") @Valid TipoUsuario tipousuario, BindingResult result, Model model, SessionStatus status) 
			throws Exception 
	{
		if (result.hasErrors()) 
		{
			return "tipousuario/tipousuario";
		} 
		else 
		{
			int rpta = cS.insert(tipousuario);
			if (rpta > 0) 
			{
				model.addAttribute("mensaje", "Ya existe, ingrese un nuevo tipo de usuario");
				return "tipousuario/tipousuario";
			} 
			else 
			{
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("tipousuario", new TipoUsuario());
		return "redirect:/tipousuarios/list";
		
		
	}
	
	@RequestMapping("/delete")
	public String deleteTipoUsuario(Model model, @RequestParam(value = "id") Integer id, @ModelAttribute("tipousuario") @Valid TipoUsuario tipousuario) {
		cS.delete(id);
		model.addAttribute("tipousuario", tipousuario);
		model.addAttribute("listaTipoUsuarios", cS.list());
		return "tipousuario/listTipoUsuarios";
	}

	@RequestMapping("/update/{id}")
	public String updateTipoUsuario(@PathVariable int id, Model model, RedirectAttributes objRedirect) {
		Optional<TipoUsuario> tipousuario = cS.listId(id);
		if (tipousuario == null) {
			objRedirect.addFlashAttribute("mensaje", "Ocurrio un error");
			return "tipousuarios/tipousuarios";
		} else {
			model.addAttribute("tipousuario", tipousuario);
			return "tipousuario/tipousuario";
		}
	}
}