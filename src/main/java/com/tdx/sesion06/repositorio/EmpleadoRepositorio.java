package com.tdx.sesion06.repositorio;

import com.tdx.sesion06.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
