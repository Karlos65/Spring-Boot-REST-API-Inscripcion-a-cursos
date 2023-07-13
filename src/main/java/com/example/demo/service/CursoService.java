package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CursoDTO;
import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;

	public CursoDTO saveCurso(CursoDTO cursoDTO) {
		Curso curso = new Curso(
				null,
				cursoDTO.getDescripcion(),
				cursoDTO.getFechaDeInicio(),
				cursoDTO.getFechaDeFin(),
				cursoDTO.getNombre()
				);
		cursoRepository.save(curso);
		return cursoDTO;
	}

}
