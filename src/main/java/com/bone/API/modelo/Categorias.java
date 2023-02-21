package com.bone.API.modelo;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
        
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categorias {
    @Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripción; 
     @OneToMany(mappedBy= "categorias")
    private List<Productos> producto;

}


