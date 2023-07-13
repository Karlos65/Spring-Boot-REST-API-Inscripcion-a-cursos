package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Estado;
import com.example.demo.entity.Estudiante;
import com.example.demo.entity.Inscripcion;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

@Service
public class InscripcionService {
	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private InscripcionRepository inscripcionRepository;

	@Transactional
	public void inscr(@NotNull Long estudianteId, @NotNull Long cursoId, LocalDate fechaDeInscripcion, Estado estado) {
		Estudiante estudiante = estudianteRepository
				.findById(estudianteId)
				.orElseThrow(()-> new RuntimeException("El id del estudiante no es valido"));

		if(!estudiante.esMayorEdad()) {
			throw new RuntimeException("El customer es menor de edad");
		}

		Curso curso = cursoRepository
				.findById(cursoId)
				.orElseThrow(()-> new RuntimeException("El id del curso no es valido"));

		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setEstado(estado);
		inscripcion.setFechaDeInscripcion(LocalDate.now());
		inscripcion.setCurso(curso);
		inscripcion.setEstudiante(estudiante);

		inscripcionRepository.save(inscripcion);
	}
}
