package pe.edu.upc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Alerta;
import pe.edu.upc.entities.Usuario;

@Repository
public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
	@Query("select count(a.idUsuarioRes) from Alerta a where a.idUsuarioRes=:name")
	public int buscarAlerta(@Param("name") Usuario nombre);
	
	@Query(value = "SELECT u.fistname_usuario, u.lastname_usuario, count(al.id_usuario_res) "
			+ "from Usuario u join alertas al on u.id_usuario = al.id_usuario_res "
			+ "group by u.fistname_usuario, u.lastname_usuario "
			+ "ORDER BY count(al.id_usuario_res) asc ", nativeQuery = true)
	public List<String[]> RescatistaAlertas();
}
