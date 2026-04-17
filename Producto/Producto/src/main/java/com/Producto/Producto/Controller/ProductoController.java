package com.Producto.Producto.Controller;

import com.Producto.Producto.model.Producto;
import com.Producto.Producto.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@Valid @RequestBody Producto producto) {
        return new ResponseEntity<>(service.guardar(producto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> eliminar(@PathVariable String nombre) {
        service.eliminarPorNombre(nombre);
        return ResponseEntity.noContent().build();
    }
}