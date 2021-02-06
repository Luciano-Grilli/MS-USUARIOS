package com.formaciondbi.microservicios.app.usuarios.models.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;


import com.formaciondbi.microservicios.generics.models.entity.Alumno;
import com.formaciondbi.microservicios.generics.repository.Repository;

public interface AlumnoRepository extends Repository<Alumno, Long> {
	
	@Query("select a from Alumno a where upper(a.nombre) like upper(concat('%', ?1, '%')) or upper(a.apellido) like upper(concat('%', ?1, '%'))")
	public List<Alumno> finByNombreOrApellido(String term);


}
