package com.mx.ATM.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ATM.Entity.Cajero;
import com.mx.ATM.Entity.Transacciones;
import com.mx.ATM.Service.CajeroServiceImpl;

@RestController
@RequestMapping("/Cajero")
//@CrossOrigin("*")
public class CajeroWS {

	@Autowired
	private CajeroServiceImpl service;
	
		//Endpoint para retirar Efectivo
		//http://localhost:8005/Cajero/retirar?{monto}
	    @PostMapping("/retirar")
	    public Map<String, Integer> retirarEfectivo(@RequestParam double monto) {
	        return service.retirarEfectivo(monto);
	    }
	

		 // Obtener todas las transacciones
		 // http://localhost:8005/Cajero/transacciones
		 @GetMapping("/transacciones")
		 public List<Transacciones> obtenerTransacciones() {
		     return service.obtenerTransacciones();
		 }

	    
	    
		//Metodo GET -LISTAR
		//http://localhost:8005/Cajero
		@GetMapping
		public List<Cajero> listar(){
			return service.listar();
		}
		
		//BUSCAR
		//http://localhost:8005/Cajero
		@PostMapping("/{idCajero}")
		public Cajero buscar(@PathVariable int idCajero) {
			return service.buscar(idCajero);
		}
		
		
		//Metodo POST - GUARDAR
		//http://localhost:8005/Cajero
		@PostMapping
		public Cajero guardar(@RequestBody Cajero cajero) {
			return service.guardar(cajero);
		}
		
		
		//EDITAR	
		@PutMapping
		public Cajero editar(@RequestBody Cajero cajero) {
			return service.editar(cajero);
		}
		
		//ELIMINAR
		//http://localhost:8005/Cajero
		@DeleteMapping
		public Cajero eliminar(@RequestBody Cajero cajero) {
			return service.eliminar(cajero);
		}
	
}
