package com.mx.Proveedores.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Proveedores.Entity.Proveedores;
import com.mx.Proveedores.Service.ProveedoresServiceImpl;

@RestController
@RequestMapping("/Proveedor") 
//http://localhost:8011/Proveedor
public class ProveedoresWS {

	@Autowired
	private ProveedoresServiceImpl service;
	
	//Endpoint Listar
	//http://localhost:8011/Proveedor
	@GetMapping
	public ResponseEntity<?> listarProveedores(){
		List<Proveedores> proveedor = service.listar();
		
		if(proveedor.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.ok(proveedor);
		}
	}	
	
	 // Endpoint para buscar un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> obtenerProveedor(@PathVariable int id) {
        Proveedores proveedor = service.buscar(id);
        return (proveedor != null) ? ResponseEntity.ok(proveedor) : ResponseEntity.notFound().build();
    }

    // Endpoint para buscar una tienda por tiendaId
    @GetMapping("/Tienda/{tiendaId}")
 
    public ResponseEntity<List<Proveedores>> findByTiendaId(@PathVariable int tiendaId) {
        List<Proveedores> proveedor = service.findByTiendaId(tiendaId);
        return proveedor.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(proveedor);
    }
    
    
    
    // Endpoint para guardar un proveedor
    @PostMapping
    public ResponseEntity<Proveedores> guardarProveedor(@RequestBody Proveedores proveedor) {
        Proveedores nuevoProveedor = service.guardar(proveedor);
        return ResponseEntity.ok(nuevoProveedor);
    }

    // Endpoint para editar un proveedor
    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> editarProveedor(@PathVariable int id, @RequestBody Proveedores proveedor) {
        proveedor.setId(id); 
        Proveedores actualizado = service.editar(proveedor);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    // Endpoint para eliminar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Proveedores> eliminarProveedor(@PathVariable int id) {
        Proveedores eliminado = service.eliminar(id);
        return (eliminado != null) ? ResponseEntity.ok(eliminado) : ResponseEntity.notFound().build();
    }
	
}
