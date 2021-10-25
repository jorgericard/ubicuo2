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

import pe.edu.upc.entities.TipoUsuario;
import pe.edu.upc.serviceinterface.ITipoUsuarioService;

@Controller
@RequestMapping("/TipoUsuarios")
public class TipoUsuarioController 
{
	@Autowired
	private ITipoUsuarioService cS;
	
	@GetMapping("/new")
	public String newTipoUsuario(Model model) 
	{
		model.addAttribute("TipoUsuario", new TipoUsuario());
		return "TipoUsuario/TipoUsuario";
	}
	
	@GetMapping("/list")
	public String listTipoUsuarios(Model model) 
	{
		try 
		{
			model.addAttribute("TipoUsuario", new TipoUsuario());
			model.addAttribute("listaTipoUsuarios", cS.list());
		} 
		catch (Exception e) 
		{
			model.addAttribute("error", e.getMessage());
		}
		return "TipoUsuario/listTipoUsuarios";
	}
	
	@PostMapping("/save")
	public String saveMarca(@Valid TipoUsuario TipoUsuario, BindingResult result, Model model, SessionStatus status) throws Exception 
	{
		if (result.hasErrors()) 
		{
			return "TipoUsuario/TipoUsuario";
		} 
		else 
		{
			int rpta = cS.insert(TipoUsuario);
			if (rpta > 0) 
			{
				model.addAttribute("mensaje", "Ya existe");
				return "TipoUsuario/TipoUsuario";
			} 
			else 
			{
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("TipoUsuario", new TipoUsuario());
		return "redirect:/TipoUsuarios/list";
	}
}