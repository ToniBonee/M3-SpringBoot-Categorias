package com.bone.API.service;

import com.bone.API.modelo.Productos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bone.API.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public List<Productos>listarProductos(){
        return repository.findAll();
    }
    
    public void guardarProductos(Productos producto){
        repository.save(producto);
    }
    
    public Productos obtenerProductoPorId(Integer id){
        return repository.findById(id).get();
    }
    
    public void eliminarProductos(Integer id) {
        repository.deleteById(id);
    }
}
