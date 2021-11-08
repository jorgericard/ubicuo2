package pe.edu.upc.serviceimplement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.TipoUsuario;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.repositories.IUsuarioRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService
{
	@Autowired
	private IUsuarioRepository uR;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException 
	{
		Usuario usuario = uR.findByDni(dni);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(TipoUsuario tipousuario : usuario.getTipousuarios())
		{
			authorities.add(new SimpleGrantedAuthority(tipousuario.getNameTipoUsuario()));
		}
		
		return new User(usuario.getDni(),usuario.getPassword(),usuario.getEnabled(),true,true,true,authorities);
	}

}
