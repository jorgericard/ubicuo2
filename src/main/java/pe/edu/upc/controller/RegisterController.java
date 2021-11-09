package pe.edu.upc.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.serviceinterface.ICargoService;
import pe.edu.upc.serviceinterface.IServicioService;
import pe.edu.upc.serviceinterface.ITipoUsuarioService;
import pe.edu.upc.serviceinterface.IUbicacionService;
import pe.edu.upc.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/register")
public class RegisterController 
{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
	
	@Autowired
	private pe.edu.upc.serviceinterface.IUploadFileService uploadFileService;
	
	@GetMapping("/new")
	public String register(Model model) 
	{
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listatipousuarios", iS.list());
		model.addAttribute("listaubicacion", ubS.list());
		model.addAttribute("listacargo", cS.list());
		model.addAttribute("listaservicio", sS.list());
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@PostMapping("/save")
	public String saveUser(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) throws Exception 
	{
		if (result.hasErrors()) 
		{
			return "register";
		} 
		else 
		{
			String bcryptPassword = passwordEncoder.encode(usuario.getPassword());
			usuario.setPassword(bcryptPassword);
			usuario.setEnabled(true);
			usuario.setIdUsuario(usuario.getIdUsuario());
			
			int rpta = usS.insert(usuario);
			
			if (rpta > 0) 
			{
				model.addAttribute("mensaje", "Ya existe");
				return "register";
			} 
			else 
			{
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		
		model.addAttribute("listaUsuarios", usS.list());

		return "login";
	}
}
