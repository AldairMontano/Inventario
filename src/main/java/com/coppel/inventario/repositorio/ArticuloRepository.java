package com.coppel.inventario.repositorio;

import com.coppel.inventario.entidad.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

    @Query("SELECT a FROM Articulo a WHERE " +
            "CONCAT(a.sku, a.articulo, a.modelo, a.marca) " +
            "LIKE %?1%")
    public List<Articulo> findAll(String clave);
}
