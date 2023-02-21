package com.bone.API.repository;
import com.bone.API.modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductoRepository extends JpaRepository<Productos, Integer>{
    
}
