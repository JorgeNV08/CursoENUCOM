package com.mx.Tienda.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.FeignClients.IClientesFeign;
import com.mx.Tienda.FeignClients.IProductosFeign;
import com.mx.Tienda.FeignClients.IProveedoresFeign;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Repository.ITiendaEntity;

@Service
@SuppressWarnings("unchecked")
public class TiendaServImpl implements ITiendaService {

	//*************************INYECCIÓN DE DEPENDENCIAS
	@Autowired
	private ITiendaEntity dao;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IClientesFeign clientesFC;
	
	@Autowired
	private IProductosFeign productosFC;
	
	@Autowired 
	private IProveedoresFeign proveedoresFC;
	
	
	//*************************SERVICIOS DE TIENDA
	@Override
	public Tienda guardar(Tienda tienda) {
		return dao.save(tienda);
	}

	@Override
	public Tienda editar(Tienda tienda) {
		Tienda aux = this.buscar(tienda.getIdTienda());
		if(aux!=null) {
			return dao.save(tienda);
		}
		return null;
	}
	
	@Override
	public Tienda eliminar(int idTienda) {
		Tienda aux = this.buscar(idTienda);
		if(aux!=null) {
			dao.deleteById(idTienda);
			return aux;
		}
		return null;
	}

	@Override
	public Tienda buscar(int idTienda) {
		return dao.findById(idTienda).orElse(null);
	}

	@Override
	public List<Tienda> listar() {
		return dao.findAll(Sort.by(Direction.DESC,"idTienda"));
	}

	
	
	//*************************SERVICIOS DE CLIENTES
		// Metodos con FeignClient
	public Clientes saveCliente(Clientes cliente) {
		return clientesFC.save(cliente);
	}
	
	public List<Clientes> getClientes(int tiendaId){
		return clientesFC.getClientesByTiendaId(tiendaId);
	}
	
		//Métodos con RestTemplate
	public Clientes saveClienteRT(Clientes cliente) {
		
		ResponseEntity<Clientes> response = restTemplate
				.postForEntity("http://localhost:8013", cliente, Clientes.class);		
		return response.getBody();
	}
	
	
	public List<Clientes> getClientesRT(int tiendaId){		
		return restTemplate.postForObject("http://localhost:8013/tienda/" + tiendaId, null, List.class);
		
	}
	
	//*************************SERVICIOS DE PRODUCTOS
		//Metodos con Feign Client
	public Productos saveProducto(Productos producto) {
		return productosFC.save(producto);
	}
	
	public List<Productos> getProductos(int idProducto) {
		return productosFC.getProductosById(idProducto);
	}
	
	
		//Métodos con REstTemplate
	public Productos saveProductoRT(Productos producto) {
		ResponseEntity<Productos> response = restTemplate
				.postForEntity("http://localhost:8010", producto, Productos.class);
		return response.getBody();
	}
	
	public List<Productos> getProductosRT(int tiendaId) {
		return restTemplate.getForObject("http://localhost:8010/Producto/tienda/"+ tiendaId, List.class);
	}
	
	//*************************SERVICIOS DE PROVEEDORES
		//Metodos con Feign Client
	public Proveedores saveProveedor(Proveedores proveedor) {
		return proveedoresFC.save(proveedor);
	}
	
	public List<Proveedores> getProveedor(int id) {
		return proveedoresFC.getProveedorById(id);
	}
	
		//Metodos RestTemplate
	public Proveedores saveProveedorRT(Proveedores proveedor) {
		ResponseEntity<Proveedores> response = restTemplate
				.postForEntity("http://localhost:8011/Proveedor", proveedor, Proveedores.class);
	
		return response.getBody();
	}
	
	public List<Proveedores> getProveedorRT(int id) {
		return restTemplate.getForObject("http://localhost:8011/Proveedor" + id, List.class);
	}
	
	
	//*********************************************************************************
	//	Método para obtener toda la relación de la TIENDA y sus MÓDULOS (Microservicios)
	//*********************************************************************************
	
	public Map<String, Object> obtenerTodosLosModulos(int tiendaId){
		
		Map<String, Object> resultado = new HashMap<>();
		
		//Consultar y validar la Tienda
		Tienda tienda = this.buscar(tiendaId);
		
		if(tienda == null) {
			resultado.put("Mensaje", "La tienda con ID: " + tiendaId + " no existe.");
			return resultado;
		}
		resultado.put("Tienda", tienda);
		
		//Consultar y validar los Clientes
		List<Clientes> clientes = this.getClientes(tiendaId);
		
		if (clientes.isEmpty() || clientes == null) {
			resultado.put("Clientes", "La tienda no tiene clientes");	
		} else {
			resultado.put("Clientes", clientes);
		}
		
		
		//Consultar y validar los Productos
		List<Productos> productos = this.getProductosRT(tiendaId);
		
		if (productos.isEmpty() || productos == null) {
			resultado.put("Productos", "La tienda no tiene productos.");	
		} else {
			resultado.put("Productos", productos);
		}
		
		
		
		//Consultar y validar los Proveedores
		List<Proveedores> proveedores =this.getProveedor(tiendaId);
		
		if (proveedores.isEmpty() || proveedores == null) {
			resultado.put("Productos", "La tienda no tiene proveedores.");	
		} else {
			resultado.put("Proveedores", proveedores);
		}
		
		return resultado;
	}	
	
	
	
}