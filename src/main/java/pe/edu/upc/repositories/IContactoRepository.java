package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Contacto;

@Repository
public interface IContactoRepository extends JpaRepository<Contacto, Integer>{
	
	@Query("select count(c.nameContacto) from Contacto c where c.nameContacto=:name")
	public int contactosExistentes(@Param("name") String nombre);

}
