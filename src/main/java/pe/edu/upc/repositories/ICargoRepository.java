package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entities.Cargo;

public interface ICargoRepository extends JpaRepository<Cargo, Integer>
{
	@Query("select count(c.nameCargo) from Cargo c where c.nameCargo=:name")
	public int cargosExistentes(@Param("name") String nombre);
}
