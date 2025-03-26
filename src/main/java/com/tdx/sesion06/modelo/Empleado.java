package com.tdx.sesion06.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empleado {
    @Id
    private Long id;
    private String nombre;
    private String departamento;

    // Constructores
    public Empleado() {}

    public Empleado(Long id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}
