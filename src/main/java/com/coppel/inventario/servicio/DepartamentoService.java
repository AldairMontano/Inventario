package com.coppel.inventario.servicio;

import com.coppel.inventario.entidad.Departamento;
import com.coppel.inventario.repositorio.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }
}
