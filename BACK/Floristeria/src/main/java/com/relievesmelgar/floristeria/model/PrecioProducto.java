package com.relievesmelgar.floristeria.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Precio_Producto")
public class PrecioProducto implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRECIO")
    private Integer idPrecio;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;

    @JoinColumn(name = "PRECIO")
    private BigDecimal precio;

    @Column(name = "FECHA_INICIO")
    private LocalDateTime fechaInicio;

    @Column(name = "FECHA_FIN")
    private LocalDateTime fechaFin;

    @PrePersist
    public void prePersist() {
        fechaInicio = LocalDateTime.now();
    }
	
}
