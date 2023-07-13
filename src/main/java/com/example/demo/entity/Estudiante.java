package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 30)
	private String nombre;
	
	@Column(name = "apel", nullable = false, length = 30)
	private String apellido;

	@Column(name = "dni")
	private int dni;
	
	@Column(name = "age")
	private int Age;
	
	@Column(length = 40)
	private String email;
	
	@Transient
	private int edad;
	
	@Column(name = "fecha_nac", nullable = false, length = 10)
	private LocalDate fechaDeNacimiento;
	
	public boolean esMayorEdad() {
		return Age >=18;
	}
}
