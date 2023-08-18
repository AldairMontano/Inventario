package com.coppel.inventario.servicio;

import com.coppel.inventario.entidad.Departamento;
import com.coppel.inventario.entidad.Familia;
import com.coppel.inventario.repositorio.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliaService {

    @Autowired
    FamiliaRepository familiaRepository;

    public List<Familia> listarFamilias() {
        return familiaRepository.findAll();
    }
}
