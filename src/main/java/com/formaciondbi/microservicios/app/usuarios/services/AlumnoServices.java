package com.formaciondbi.microservicios.app.usuarios.services;



import com.formaciondbi.microservicios.app.usuarios.models.entity.Alumno;

public interface AlumnoServices {
	
	public Iterable<Alumno>findAll() throws Exception;
	
	public Alumno findById(Long id) throws Exception;
	
	public Alumno update(Long id, Alumno alumno)throws Exception;
	
	public Alumno save(Alumno alumno) throws Exception;
	
	public boolean deleteById(Long id) throws Exception;
}
