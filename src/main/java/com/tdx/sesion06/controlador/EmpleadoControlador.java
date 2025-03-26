package com.tdx.sesion06.controlador;

import com.tdx.sesion06.modelo.Empleado;
import com.tdx.sesion06.servicio.EmpleadoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoControlador {
    private final EmpleadoServicio servicio;

    public EmpleadoControlador(EmpleadoServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping
    public List<Empleado> obtenerTodos(){
        return  servicio.otenerTodos();
    }
}

