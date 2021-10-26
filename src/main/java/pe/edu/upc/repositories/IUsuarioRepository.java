package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>
{
	@Query("select count(c.nameUsuario) from Usuario c where c.nameUsuario=:name")
	public int UsuariosExistentes(@Param("name") String nombre_apellido);
}