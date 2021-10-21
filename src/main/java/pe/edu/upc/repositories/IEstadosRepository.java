package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Estados;

@Repository
public interface IEstadosRepository extends JpaRepository<Estados, Integer>{
	@Query("select count(c.nnombreestados) from Estados c where c.nnombreestados=:name")
	public int categoriasExistentes(@Param("name") String nombre);

}
