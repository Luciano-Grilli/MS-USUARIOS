package com.formaciondbi.microservicios.app.usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formaciondbi.microservicios.app.usuarios.models.entity.Alumno;
import com.formaciondbi.microservicios.app.usuarios.models.repository.AlumnoRepository;

@Service
public class AlumnoServicesImpl implements AlumnoServices {

	@Autowired
	private AlumnoRepository repository;

	
	@Override
	@Transactional
	public Iterable<Alumno> findAll() throws Exception {
		
		try {
			Iterable<Alumno>entities = repository.findAll();
			return entities;
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	@Transactional
	public Alumno findById(Long id) throws Exception {
		try {
			Optional<Alumno> entities = repository.findById(id);
			
			return entities.get();
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Alumno update(Long id, Alumno alumno) throws Exception {
		try {
			Optional<Alumno> entityOptional = repository.findById(id);
			Alumno entity = entityOptional.get();
			entity = repository.save(alumno);
			return entity;
				
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) throws Exception {
		try {
			alumno = repository.save(alumno);
			
			return alumno;
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean deleteById(Long id) throws Exception {
		
		try {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	/*
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		
		return repository.save(alumno);
	}
	
	@Override
	@Transactional
	public Alumno update(Long id,Alumno alumno) {
		
		return repository.(alumno);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}
	*/

}
