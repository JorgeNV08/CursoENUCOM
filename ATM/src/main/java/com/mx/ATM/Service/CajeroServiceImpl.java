package com.mx.ATM.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ATM.Dao.ICajeroDao;
import com.mx.ATM.Dao.IDenominacionDao;
import com.mx.ATM.Dao.IDetalleTransaccionDao;
import com.mx.ATM.Dao.ITransaccionesDao;
import com.mx.ATM.Entity.Cajero;
import com.mx.ATM.Entity.Denominacion;
import com.mx.ATM.Entity.DetalleTransaccion;
import com.mx.ATM.Entity.Transacciones;

@Service
@Transactional
public class CajeroServiceImpl implements ICajeroService{

	@Autowired
	private ICajeroDao dao;
	@Override
	public Cajero guardar(Cajero cajero) {
		return dao.save(cajero);
	}

	@Override
	public Cajero editar(Cajero cajero) {
		Cajero aux = this.buscar(cajero.getIdCajero());
		if(aux != null) {
			return dao.save(cajero);
		}
		return null;
	}

	@Override
	public Cajero eliminar(Cajero cajero) {
		Cajero aux = this.buscar(cajero.getIdCajero());
		if(aux != null) {
			dao.delete(cajero);
			return aux;
		}
		return null;
	}

	@Override
	public Cajero buscar(int idCajero) {
		return dao.findById(idCajero).orElse(null);
	}

	@Override
	public List<Cajero> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idCajero"));
	}

	@Autowired
	private IDenominacionDao denominacionDao;
	@Autowired
	private ITransaccionesDao transaccionDao;
	@Autowired
	private IDetalleTransaccionDao detalleTransDao;
	
	@Override
	public Map<String, Integer> retirarEfectivo(double monto) {
		Map<String, Integer> denominacionesEntregadas = new HashMap<>();
		
		// Obtener las denominaciones disponibles
        List<Denominacion> denominaciones = denominacionDao.findAll();

        // Ordenar las denominaciones por valor nominal de mayor a menor
        denominaciones.sort((d1, d2) -> Double.compare(d2.getValorNominal().getValor(), d1.getValorNominal().getValor()));
		
        //Obteniendo el unico cajero disponible
        //Cajero cajero = new Cajero();
        //cajero.setIdCajero(1);
        Cajero cajero = dao.findById(1).orElseThrow(() -> new RuntimeException("Cajero no encontrado"));

        
        // Obtener el último ID de la transacción
        Integer lastTransactionId = transaccionDao.getLastTransactionId();
        
        // Generar el nuevo ID para la transacción
        Integer newTransactionId = (lastTransactionId == null) ? 1 : lastTransactionId + 1;
        
        // Registrar la transacción
        Transacciones transaccion = new Transacciones();
        transaccion.setIdTransaccion(newTransactionId);  // Asignar el nuevo ID
        transaccion.setMontoSolicitado((long) monto);  // El monto total retirado
        transaccion.setFechaTransaccion(LocalDateTime.now());  // Fecha y hora actual de la transacción
        transaccion.setCajero(cajero);
        
        // Guardar la transacción
        transaccionDao.save(transaccion);
        
        
        for (Denominacion denominacion : denominaciones) {
            int cantidadDisponible = denominacion.getCantidadDisponible();
            double valorDenominacion = denominacion.getValorNominal().getValor();

            // Verificar cuántas de estas denominaciones se pueden entregar
            int cantidadParaRetirar = (int) (monto / valorDenominacion);
            if (cantidadParaRetirar > cantidadDisponible) {
                cantidadParaRetirar = cantidadDisponible;
            }
            
            // Actualizamos el monto a entregar y el contador de denominaciones
            if (cantidadParaRetirar > 0) {
                denominacionesEntregadas.put(denominacion.getValorNominal().getValor() + " " + denominacion.getTipoEfectivo().getTipo(), cantidadParaRetirar);
                monto -= cantidadParaRetirar * valorDenominacion;

                // Actualizamos la denominación
                denominacion.setCantidadDisponible(cantidadDisponible - cantidadParaRetirar);
                denominacionDao.save(denominacion);
                
             // Guardar el detalle de la transacción
                /*DetalleTransaccion detalle = new DetalleTransaccion();
                detalle.setTransaccion(transaccion); // Asociamos la transacción ya guardada
                detalle.setCantidadEntregada(cantidadParaRetirar * valorDenominacion); // Calculamos la cantidad entregada
                detalle.setDenominacion(denominacion); // Asociamos la denominación entregada
                detalleTransDao.save(detalle); // Guardamos el detalle de la transacción
   				*/
            }
            
            if (monto <= 0) {
                break; // Si el monto es 0, terminamos el ciclo
            }
        }
        
        if (monto > 0) {
            throw new RuntimeException("No se puede entregar el monto solicitado con las denominaciones disponibles.");
        }
        
        
     // Calcula el monto total entregado sumando el valor de cada denominación entregada:
     // 1. `denominacionesEntregadas.entrySet()` obtiene el conjunto de entradas (clave-valor) del mapa.
     // 2. `.stream()` convierte el conjunto de entradas en un flujo para poder procesarlas.
     // 3. `.mapToLong(entry -> entry.getValue() * Long.parseLong(entry.getKey().split(" ")[0]))`
     //	- Obtiene la cantidad de billetes (entry.getValue()) y el valor nominal de la denominación (extraído de la clave).
     // - Multiplica la cantidad de billetes por el valor nominal de cada denominación.
     // 4. `.sum()` suma los montos entregados de todas las denominaciones para obtener el monto total.

        Long montoEntregado = denominacionesEntregadas.entrySet().stream()
            .mapToLong(entry -> entry.getValue() * Long.parseLong(entry.getKey().split(" ")[0]))
            .sum();
        
        // Actualizamos el monto entregado en la transacción
        transaccion.setMontoEntregado(montoEntregado);
        transaccionDao.save(transaccion);  // Guardar la transacción con el monto entregado
        
	
	return denominacionesEntregadas;
     
	}

	@Override
	public List<Transacciones> obtenerTransacciones() {
	    return transaccionDao.findAll(Sort.by(Direction.DESC, "idTransaccion")); 
	}

	
}
