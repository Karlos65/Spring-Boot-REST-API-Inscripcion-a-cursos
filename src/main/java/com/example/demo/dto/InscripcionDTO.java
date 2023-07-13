package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InscripcionDTO {
	private LocalDate fechaDeInscripcion;
	private Long curso;
	private Long estudiante;
	private Estado estado;
}
