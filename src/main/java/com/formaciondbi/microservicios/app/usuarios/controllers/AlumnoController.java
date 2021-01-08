package com.formaciondbi.microservicios.app.usuarios.controllers;



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
	private AlumnoServices service;
	
	

	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("metodo no funciona");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("metodo no funciona");
		}
		
	}
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Alumno alumno){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(alumno));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("metodo no funciona");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Alumno alumno){
		try {

			return ResponseEntity.status(HttpStatus.OK).body(service.update(id,alumno));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("metodo no funciona");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteById(id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("metodo no funciona");
		}
	}
	
	/*
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
	public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Alumno alumno){
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
	*/
}

