package com.bone.API.service;

import com.bone.API.modelo.Clientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bone.API.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Clientes>listarClientes(){
        return repository.findAll();
    }
    
    public void guardarClientes(Clientes cliente){
        repository.save(cliente);
    }
    
    public Clientes obtenerClientePorId(Integer id){
        return repository.findById(id).get();
    }
    
    public void eliminarClientes(Integer id) {
        repository.deleteById(id);
    }
}
