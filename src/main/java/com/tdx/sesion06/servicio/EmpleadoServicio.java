package com.tdx.sesion06.servicio;

import com.tdx.sesion06.modelo.Empleado;
import com.tdx.sesion06.repositorio.EmpleadoRepositorio;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio {
    private  final EmpleadoRepositorio repositorio;

    public EmpleadoServicio(EmpleadoRepositorio repositorio){
        this.repositorio = repositorio;
    }
    @Cacheable(value="empleados", key = "'todos'")
    public List<Empleado> otenerTodos(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return  repositorio.findAll();
    }
}
