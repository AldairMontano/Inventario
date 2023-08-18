package com.coppel.inventario.servicio;

import com.coppel.inventario.entidad.Articulo;
import com.coppel.inventario.repositorio.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    public List<Articulo> listarArticulos(String clave) {
        if (clave != null) {
            return articuloRepository.findAll(clave);
        }
        return articuloRepository.findAll();
    }

    public void altaArticulo(Articulo articulo) {
        articuloRepository.save(articulo);
    }
    public Articulo obtenerArticuloPorSku(Long id) {
        return articuloRepository.findById(id).get();
    }
    public void actualizarArticulo(Articulo articulo) {
        articuloRepository.save(articulo);
    }
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}
