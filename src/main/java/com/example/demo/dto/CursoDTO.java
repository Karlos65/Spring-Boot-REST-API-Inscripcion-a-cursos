package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CursoDTO {
	private String descripcion;
	private LocalDate fechaDeInicio;
	private LocalDate fechaDeFin;
	private String nombre;
}
