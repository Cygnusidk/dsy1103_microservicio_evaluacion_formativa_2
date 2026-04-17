package com.Producto.Producto.service;

import com.Producto.Producto.model.Producto;
import com.Producto.Producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    @Transactional
    public void eliminarPorNombre(String nombre) {
        repository.deleteByNombre(nombre);
    }
}