package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EstudianteDTO;
import com.example.demo.entity.Estudiante;
import com.example.demo.repository.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	public EstudianteDTO saveEstudiante(EstudianteDTO estudianteDTO) {
		Estudiante estudiante = new Estudiante(
				null,
				estudianteDTO.getNombre(),
				estudianteDTO.getApellido(),
				estudianteDTO.getDni(),
				estudianteDTO.getAge(),
				estudianteDTO.getEmail(),
				estudianteDTO.getEdad(),
				estudianteDTO.getFechaDeNacimiento()
				);
		estudianteRepository.save(estudiante);
		return estudianteDTO;
	}

	public List<EstudianteDTO> findAll(){
		return estudianteRepository.findAll()
				.stream().map(e -> new EstudianteDTO(e.getNombre(),e.getApellido(),e.getDni(),e.getAge(),e.getEmail(),e.getEdad(),e.getFechaDeNacimiento()))
				.collect(Collectors.toList());
	}

	public EstudianteDTO update(Long id, EstudianteDTO estudianteDTO) {
		Estudiante estudiante = new Estudiante(id, estudianteDTO.getNombre(),estudianteDTO.getApellido(),estudianteDTO.getDni(),estudianteDTO.getAge(),estudianteDTO.getEmail(),estudianteDTO.getEdad(),estudianteDTO.getFechaDeNacimiento());
		estudianteRepository.save(estudiante);
		return estudianteDTO;
	}

	public EstudianteDTO find(Long id) {
		Optional<Estudiante> estudianteOptional=estudianteRepository.findById(id);

		if(estudianteOptional.isEmpty()) {
			throw new RuntimeException("Id invalido");
		}
		Estudiante estudiante = estudianteOptional.get();
		return new EstudianteDTO(estudiante.getNombre(), estudiante.getApellido(),estudiante.getDni(),estudiante.getAge(),estudiante.getEmail(),estudiante.getEdad(),estudiante.getFechaDeNacimiento());
	}

	public void delete(Long id) {
		estudianteRepository.deleteById(id);
	}

}
