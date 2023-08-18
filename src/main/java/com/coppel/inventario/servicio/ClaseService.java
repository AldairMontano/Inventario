package com.coppel.inventario.servicio;

import com.coppel.inventario.entidad.Clase;
import com.coppel.inventario.entidad.Departamento;
import com.coppel.inventario.repositorio.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {

    @Autowired
    ClaseRepository claseRepository;

    public List<Clase> listarClases() {
        return claseRepository.findAll();
    }
}
