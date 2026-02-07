package com.relievesmelgar.floristeria.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
@Table(name = "Productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO")
	private Long idProducto;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "FOTO")
	private String foto;

	@Column(name = "ESTADO")
	private Boolean estado;

	@Column(name = "FECHA_CREACION")
	private LocalDateTime fechaCreacion;

	@Column(name = "FECHA_ACTUALIZACION")
	private LocalDateTime fechaActualizacion;

    @ManyToMany
    @JoinTable(
        name = "Producto_Categoria",
        joinColumns = @JoinColumn(name = "id_producto"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
	private List<Categoria> categorias;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PrecioProducto> precios;

	 @PrePersist
	    public void prePersist() {
	        fechaCreacion = LocalDateTime.now();
	        estado = true;
	    }
}
