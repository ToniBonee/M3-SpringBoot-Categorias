package com.bone.API.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Clientes {
    @Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido; 
    private String DNI;
    private Date fecha_nacimiento; 
    private String Email; 
    private String Contrasena; 
    private String imagen; 
}
