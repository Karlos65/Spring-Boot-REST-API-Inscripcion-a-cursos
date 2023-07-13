package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstudianteDTO {
	private String nombre;
	private String apellido;
	private int dni;
	private int Age;
	private String email;
	private int edad;
	private LocalDate fechaDeNacimiento;
}
