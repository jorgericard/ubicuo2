package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entities.TipoUsuario;

public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>
{
	//@Query("select count(c.nameTipoUsuario) from TipoUsuario c where c.nameTipoUsuario=:name")
	//public int TipoUsuariosExistentes(@Param("name") String nombre);
}