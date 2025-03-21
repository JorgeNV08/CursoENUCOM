package com.mx.Tienda.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Service.TiendaServImpl;

@RestController
@RequestMapping("/Tienda") //http://localhost:8014/Tienda
@CrossOrigin
public class TiendaWS {

	@Autowired
	private TiendaServImpl service;

	@GetMapping
	public ResponseEntity<?> listar(){
		List<Tienda> tienda= service.listar();
		
		if(tienda.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(tienda);
	}
	
	@GetMapping("/{idTienda}")
	public ResponseEntity<?> buscar(@PathVariable int idTienda){
		Tienda tienda = service.buscar(idTienda);
		
		if(tienda!=null)
			return ResponseEntity.status(HttpStatus.OK).body(tienda);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Tienda tienda){
		Tienda nuevaTienda = service.guardar(tienda);
		
		if(nuevaTienda!=null)
			return ResponseEntity.status(HttpStatus.OK).body(nuevaTienda);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Tienda tienda){
		Tienda aux = service.buscar(tienda.getIdTienda());
		
		if(aux!=null)
			if(service.editar(tienda) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(tienda);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{tiendaId}") 
	public ResponseEntity<?> eliminar(@PathVariable int  tiendaId){
		Tienda aux = service.buscar(tiendaId);
		
		if(aux!=null)
			if(service.eliminar(tiendaId) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(aux);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	// ------------------------------------------------------ C L I E N T E S 
	//Endpoint Guardar Cliente
	//http://localhost:8014/Tienda/Clientes
	@PostMapping("/Clientes")
	public ResponseEntity<?> guardarCliente(@RequestBody Clientes cliente){
		Clientes nuevoCliente = service.saveCliente(cliente);
		if(nuevoCliente == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
	}
	
	@GetMapping("/Clientes/{tiendaId}")
	public ResponseEntity<?> obtenerClientes(@PathVariable int tiendaId){
		List<Clientes> clientes = service.getClientes(tiendaId);
		if(clientes == null || clientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
		 
	}
	
	// ------------------------------------------------------ P R O D U C T O S 
	//Endpoint Guardar Producto
	//http://localhost:8010/Tienda/Productos
	@PostMapping("/Producto")
	public ResponseEntity<?> guardarProducto(@RequestBody Productos producto){
		Productos nuevoProducto = service.saveProducto(producto);
		if(nuevoProducto == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
	}
	
	
	@GetMapping("/Producto/tienda/{tiendaId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable int tiendaId){
		List<Productos> producto = service.getProductosRT(tiendaId);
		if(producto == null || producto.isEmpty() ) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}
	

	// ------------------------------------------------------ P R O V E E D O R E S 
	//Endpoint Guardar Proveedores
	//http://localhost:8014/Tienda/Proveedor
	@PostMapping("/Proveedor")
	public ResponseEntity<?> guardarProveedor(@RequestBody Proveedores proveedor){
		Proveedores nuevoProveedor = service.saveProveedorRT(proveedor);
		if(nuevoProveedor == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
	}
	
	@GetMapping("/Proveedor/Tienda/{tiendaId}")
	public ResponseEntity<?> obtenerProveedores(@PathVariable int tiendaId){
		List<Proveedores> proveedor = service.getProveedor(tiendaId);
		if(proveedor.isEmpty() || proveedor == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(proveedor);
	}
	
	
	//*********************************************************************************
	//	Método para obtener toda la relación de la TIENDA y sus MÓDULOS 
	//	(Microservicios)
	//
	//	http://localhost:8014/Tienda/todo/{tiendaId}
	//*********************************************************************************
	
	@GetMapping("/todo/{tiendaId}")
	public ResponseEntity<?> obtenerTodosLosModulos(@PathVariable int tiendaId){
		Map<String,Object> modulos = service.obtenerTodosLosModulos(tiendaId);
		return ResponseEntity.status(HttpStatus.OK).body(modulos);
	}
	
	
}
