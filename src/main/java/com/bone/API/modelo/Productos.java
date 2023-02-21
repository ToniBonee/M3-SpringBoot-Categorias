package com.bone.API.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Productos {
    @Id @GeneratedValue
    private Integer id;
    private String producto;
    private Integer precio;
    private Integer stock; 
    private String imagen_producto;
    private String info_producto; 
    private Integer id_categoria; 
}
