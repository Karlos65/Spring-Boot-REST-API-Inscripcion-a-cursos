package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstudianteDTO;
import com.example.demo.service.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	@Autowired
	private EstudianteService estudianteService;

	@PostMapping
	public EstudianteDTO save(@RequestBody EstudianteDTO estudianteDTO) {
		return estudianteService.saveEstudiante(estudianteDTO);
	}

	@GetMapping
	public List<EstudianteDTO>all(){
		return estudianteService.findAll();
	}

	@GetMapping("/{id}")
	public EstudianteDTO find(@PathVariable Long id) {
		return estudianteService.find(id);
	}

	@PutMapping("/{id}")
	public EstudianteDTO update(@PathVariable Long id, @RequestBody EstudianteDTO userDTO) {
		return estudianteService.update(id, userDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		estudianteService.delete(id);
	}
}
