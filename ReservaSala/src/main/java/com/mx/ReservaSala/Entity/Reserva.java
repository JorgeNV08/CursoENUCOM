package com.mx.ReservaSala.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="RESERVA_SALA")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    
    private int salaId;
    private String usuario;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    
    @Column(insertable=false, updatable=false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;
    
    private int duracion;
    
    @Column(name="HORA")
    private LocalDateTime fechaHora;
    
    // Antes de persistir o actualizar, combinamos fecha y hora en fechaHora
    @PrePersist
    public void prePersist() {
        if (fecha != null && hora != null) {
            this.fechaHora = LocalDateTime.of(fecha, hora);
        }
    }
    
    @PreUpdate
    public void preUpdate() {
        if (fecha != null && hora != null) {
            this.fechaHora = LocalDateTime.of(fecha, hora);
        }
    }
    
    // Al cargar la entidad desde la BD, extraemos la hora de fechaHora
    @PostLoad
    public void postLoad() {
        if (fechaHora != null) {
            this.hora = fechaHora.toLocalTime();
        }
    }
}
