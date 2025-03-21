	package com.mx.Productos.Controller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.mx.Productos.Entity.Productos;
	import com.mx.Productos.Service.ProductosServiceImpl;

import jakarta.ws.rs.Path;
	
	@RestController
	@RequestMapping("/Producto") 
	public class ProductosWS {
	
		@Autowired
		private ProductosServiceImpl service;
		
		// Endpoint para listar todos los productos
	    @GetMapping
	    //http://localhost:8010/Producto
	    public ResponseEntity<List<Productos>> listarProductos() {
	        List<Productos> productos = service.listar();
	        return productos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productos);
	    }

	    // Endpoint para buscar un producto por ID
	    @GetMapping("/{idProducto}")
	    public ResponseEntity<Productos> obtenerProducto(@PathVariable int idProducto) {
	        Productos producto = service.buscar(idProducto);
	        return (producto != null) ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
	    }

	    // Endpoint para guardar un producto
	    @PostMapping
	    public ResponseEntity<Productos> guardarProducto(@RequestBody Productos producto) {
	        Productos nuevoProducto = service.guardar(producto);
	        return ResponseEntity.ok(nuevoProducto);
	    }

	    // Endpoint para editar un producto
	    @PutMapping("/{idProducto}")
	    public ResponseEntity<Productos> editarProducto(@PathVariable int idProducto, @RequestBody Productos producto) {
	        producto.setIdProducto(idProducto); // Asegurar que se edita el producto con el ID correcto
	        Productos actualizado = service.editar(producto);
	        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
	    }

	    // Endpoint para eliminar un producto
	    @DeleteMapping("/{idProducto}")
	    public ResponseEntity<Productos> eliminarProducto(@PathVariable int idProducto) {
	        Productos eliminado = service.eliminar(idProducto);
	        return (eliminado != null) ? ResponseEntity.ok(eliminado) : ResponseEntity.notFound().build();
	    }
	    
	    @GetMapping("/tienda/{tiendaId}")
	    public ResponseEntity<?> getProductosByTiendaId(@PathVariable int tiendaId){
	    	List<Productos> productos = service.byTiendaId(tiendaId);
	    	if (productos.isEmpty()) {
	    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    	}
	    	return ResponseEntity.status(HttpStatus.OK).body(productos);
	    }
		
			
		
}
