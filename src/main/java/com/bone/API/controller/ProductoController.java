package com.bone.API.controller;
import com.bone.API.modelo.Productos;
import com.bone.API.service.ProductoService;
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
public class ProductoController {
    
    private final ProductoService productoService;
    @CrossOrigin (origins = "http://localhost:8080")
    @GetMapping("/productos")
    public List<Productos> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Productos> obtenerProducto(@PathVariable Integer id) {
        try {
            Productos producto = productoService.obtenerProductoPorId(id);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/productos")
    public void nuevoProducto(@RequestBody Productos producto) {
        productoService.guardarProductos(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> editarProducto(@RequestBody Productos producto, @PathVariable Integer id) {
        try {
            Productos productoExistente = productoService.obtenerProductoPorId(id);
            productoExistente.setProducto(producto.getProducto());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());
            productoExistente.setImagen_producto(producto.getImagen_producto());
            productoExistente.setInfo_producto(producto.getInfo_producto());
            productoExistente.setId_categoria(producto.getId_categoria());
            productoService.guardarProductos(productoExistente);
            return new ResponseEntity<Productos>(producto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/productos/{id}")
    public void borrarProducto (@PathVariable Integer id){
        productoService.eliminarProductos(id);
    }
}
