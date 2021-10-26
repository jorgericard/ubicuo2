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

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.serviceinterface.ICargoService;
import pe.edu.upc.serviceinterface.IServicioService;
import pe.edu.upc.serviceinterface.ITipoUsuarioService;
import pe.edu.upc.serviceinterface.IUbicacionService;
import pe.edu.upc.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController 
{
	@Autowired
	private IUsuarioService usS;
	
	@Autowired
	private ITipoUsuarioService iS;
	
	@Autowired
	private IUbicacionService ubS;
	
	@Autowired
	private ICargoService cS;
	
	@Autowired
	private IServicioService sS;
	
	@GetMapping("/new")
	public String newusuario(Model model) 
	{
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaUsuarios", usS.list());
		model.addAttribute("listatipousuarios", iS.list());
		model.addAttribute("listaubicacion", ubS.list());
		model.addAttribute("listacargo", cS.list());
		model.addAttribute("listaservicio", sS.list());
		model.addAttribute("usuario", new Usuario());
		return "usuario/usuario";
	}
	
	@GetMapping("/list")
	public String listusuarios(Model model) 
	{
		try 
		{
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("listaUsuarios", usS.list());
		} 
		catch (Exception e) 
		{
			model.addAttribute("error", e.getMessage());
		}
		return "usuario/listUsuarios";
	}
	
	@PostMapping("/save")
	public String saveMarca(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) throws Exception 
	{
		if (result.hasErrors()) 
		{
			return "usuario/usuario";
		} 
		else 
		{
			int rpta = usS.insert(usuario);
			if (rpta > 0) 
			{
				model.addAttribute("mensaje", "Ya existe");
				return "usuario/usuario";
			} 
			else 
			{
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("usuario", new Usuario());
		return "redirect:/usuarios/list";
	}
}