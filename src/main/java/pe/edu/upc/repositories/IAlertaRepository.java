package pe.edu.upc.repositories;

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
}
