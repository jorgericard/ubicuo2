package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Alerta;

@Repository
public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
	@Query("select count(a.idAlerta) from Alerta a where a.idAlerta=:name")
	public int buscarAlerta(@Param("name") int nombre);
}
