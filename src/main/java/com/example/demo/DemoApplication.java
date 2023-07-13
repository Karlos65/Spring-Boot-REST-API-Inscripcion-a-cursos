package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Estado;
import com.example.demo.entity.Estudiante;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import com.example.demo.service.InscripcionService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	EstudianteRepository estudianteRepository;

	@Autowired
	InscripcionRepository inscripcionRepository;

	@Autowired
	InscripcionService inscripcionService;

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Curso curso = new Curso();
			curso.setDescripcion("Curso de Aleman basico");
			curso.setFechaDeInicio(LocalDate.now());
			curso.setFechaDeFin(LocalDate.now());
			curso.setNombre("Aleman1");
			cursoRepository.save(curso);

			Estudiante estudiante = new Estudiante();
			estudiante.setNombre("Pedro");
			estudiante.setApellido("Garcia");
			estudiante.setDni(30111222);
			estudiante.setEmail("pedro@garcia");
			estudiante.setFechaDeNacimiento(LocalDate.now());
			estudiante.setAge(20);
			estudianteRepository.save(estudiante);

			inscripcionService.inscr(1L, 1L, LocalDate.now(), Estado.ACEPTADO);
		};
	}
}
