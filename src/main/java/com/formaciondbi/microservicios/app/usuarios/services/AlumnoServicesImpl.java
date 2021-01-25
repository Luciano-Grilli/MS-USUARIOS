package com.formaciondbi.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formaciondbi.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.formaciondbi.microservicios.generics.models.entity.Alumno;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class AlumnoServicesImpl extends ServicesImpl<Alumno, Long> implements AlumnoServices {

	@Autowired
	protected AlumnoRepository alumnoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> finByNombreOrApellido(String term) {
		
		return alumnoRepository.finByNombreOrApellido(term);
	}

	
}
