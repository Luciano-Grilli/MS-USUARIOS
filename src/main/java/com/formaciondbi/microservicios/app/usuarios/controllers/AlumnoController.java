package com.formaciondbi.microservicios.app.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondbi.microservicios.app.usuarios.services.AlumnoServices;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.models.entity.Alumno;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
public class AlumnoController extends ControllerImpl<Alumno, ServicesImpl<Alumno,Long>>{

	@Autowired
	protected AlumnoServices alumnoServices;
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		
		return ResponseEntity.ok(alumnoServices.finByNombreOrApellido(term));
	}

	public ResponseEntity<?> save(Alumno entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

