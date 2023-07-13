package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InscripcionDTO;
import com.example.demo.service.InscripcionService;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
	@Autowired
	private InscripcionService inscripcionService;
	
	@PostMapping
	public void save(@RequestBody InscripcionDTO inscripcionDTO) {
		inscripcionService.inscr(inscripcionDTO.getCurso(), inscripcionDTO.getEstudiante(), inscripcionDTO.getFechaDeInscripcion(), inscripcionDTO.getEstado());
	}
}
