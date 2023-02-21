package com.bone.API.repository;
import com.bone.API.modelo.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
    
}
