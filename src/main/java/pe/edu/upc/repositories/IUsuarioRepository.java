package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>
{
	@Query("select count(c.nameUsuario) from Usuario c where c.nameUsuario=:name")
	public int usuariosExistentes(@Param("name") String nombre);
}