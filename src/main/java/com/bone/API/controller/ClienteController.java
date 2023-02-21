package com.bone.API.controller;

import com.bone.API.modelo.Clientes;
import com.bone.API.service.ClienteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    @CrossOrigin (origins = "http://localhost")
    @GetMapping("/clientes")
    public List<Clientes> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Clientes> obtenerCliente(@PathVariable Integer id) {
        try {
            Clientes cliente = clienteService.obtenerClientePorId(id);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/clientes")
    public void nuevoCliente(@RequestBody Clientes cliente) {
        clienteService.guardarClientes(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> editarCliente(@RequestBody Clientes cliente, @PathVariable Integer id) {
        try {
            Clientes clienteExistente = clienteService.obtenerClientePorId(id);
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setDNI(cliente.getDNI());
            clienteExistente.setFecha_nacimiento(cliente.getFecha_nacimiento());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setContrasena(cliente.getContrasena());
            clienteExistente.setImagen(cliente.getImagen());
            clienteService.guardarClientes(clienteExistente);
            return new ResponseEntity<Clientes>(cliente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Clientes>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/clientes/{id}")
    public void borrarCliente (@PathVariable Integer id){
        clienteService.eliminarClientes(id);
    }
}
