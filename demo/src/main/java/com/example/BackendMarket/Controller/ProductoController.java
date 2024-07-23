package com.example.BackendMarket.Controller;

import com.example.BackendMarket.Exception.ResourceNotFoundException;
import com.example.BackendMarket.Model.Producto;
import com.example.BackendMarket.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id " + id));
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id " + id));

        producto.setNombre(productoDetails.getNombre());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setCategoria(productoDetails.getCategoria());
        producto.setImageUrl(productoDetails.getImageUrl());
        producto.setPrecioVenta(productoDetails.getPrecioVenta());
        producto.setPrecioRegular(productoDetails.getPrecioRegular());
        producto.setCreatedAt(productoDetails.getCreatedAt());
        producto.setSlug(productoDetails.getSlug());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id " + id));
        productoRepository.delete(producto);
    }
}
