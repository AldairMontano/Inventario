package com.coppel.inventario.repositorio;

import com.coppel.inventario.entidad.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Integer> {
}
