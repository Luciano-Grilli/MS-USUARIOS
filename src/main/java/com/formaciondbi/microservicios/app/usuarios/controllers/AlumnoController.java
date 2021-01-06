package com.formaciondbi.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondbi.microservicios.app.usuarios.models.entity.Alumno;
import com.formaciondbi.microservicios.app.usuarios.services.AlumnoServices;

@RestController
public class AlumnoController {

	@Autowired
	private AlumnoServices services;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(services.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Alumno> opt = services.findById(id);
		if(opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(opt);
	}
	
	@PostMapping("/{alumno}")
	public ResponseEntity<?> crear(@RequestBody Alumno alumno){
		Alumno alumnoDb = services.save(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> aditar(@PathVariable Long id, @RequestBody Alumno alumno){
		Optional<Alumno> opt = services.findById(id);
		
		if(opt.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		
		Alumno alumnoDb = opt.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(services.save(alumnoDb));
	}
	
	
	@DeleteMapping("{/id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		services.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

