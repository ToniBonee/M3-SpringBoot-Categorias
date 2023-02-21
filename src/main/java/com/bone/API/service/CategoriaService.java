
package com.bone.API.service;

import com.bone.API.modelo.Categorias;
import com.bone.API.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public List<Categorias>listarCategorias(){
        return repository.findAll();
    }
    
    public void guardarCategorias(Categorias producto){
        repository.save(producto);
    }
    
    public Categorias obtenerCategoriaPorId(Integer id){
        return repository.findById(id).get();
    }
    
    public void eliminarCategoria(Integer id) {
        repository.deleteById(id);
    }
}
