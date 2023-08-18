package com.coppel.inventario.controlador;


import com.coppel.inventario.entidad.Articulo;
import com.coppel.inventario.servicio.ArticuloService;
import com.coppel.inventario.servicio.ClaseService;
import com.coppel.inventario.servicio.DepartamentoService;
import com.coppel.inventario.servicio.FamiliaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;

    @Autowired
    DepartamentoService departamentoService;

    @Autowired
    ClaseService claseService;

    @Autowired
    FamiliaService familiaService;

    @GetMapping({"/articulos", "/"})
    public String listarArticulos(Model modelo, @Param("clave") String clave) {
        List<Articulo> listaArticulos = articuloService.listarArticulos(clave);
        modelo.addAttribute("articulosObj", listaArticulos);
        modelo.addAttribute("clave", clave);
        return "articulos";
    }


    @PostMapping({"/articulos"})
    public String guardarArticulo(@Valid @ModelAttribute("articuloObj") Articulo articuloObj) {
            articuloService.altaArticulo(articuloObj);
            return "redirect:/articulos";
    }

    @GetMapping("/articulos/guardar")
    public String ArticuloFormulario(Model modelo) {
        Articulo articulo = new Articulo();
        modelo.addAttribute("articulosObj", articulo);
        modelo.addAttribute("deptoObj", departamentoService.listarDepartamentos());
        modelo.addAttribute("familiaObj", familiaService.listarFamilias());
        modelo.addAttribute("clasesObj", claseService.listarClases());
        return "guardar";
    }

    @GetMapping("/articulos/editar/{id}")
    public String FormEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("articulosObj", articuloService.obtenerArticuloPorSku(id));
        modelo.addAttribute("deptoObj", departamentoService.listarDepartamentos());
        modelo.addAttribute("familiaObj", familiaService.listarFamilias());
        modelo.addAttribute("clasesObj", claseService.listarClases());
        return "editarArticulo";
    }

    @PostMapping("/articulos/{id}")
    public String actualizarProducto(@PathVariable Long id,@Valid @ModelAttribute("articulosObj") Articulo articulo, Model modelo) {
        Articulo articuloModificado = articuloService.obtenerArticuloPorSku(id);
            articuloModificado.actualizar(articulo);
            articuloService.actualizarArticulo(articuloModificado);
            return "redirect:/articulos";
    }

    @GetMapping("/articulos/{id}")
    public String eliminarArticulos(@PathVariable Long id) {
        articuloService.eliminarArticulo(id);
        return "redirect:/articulos";
    }
}
