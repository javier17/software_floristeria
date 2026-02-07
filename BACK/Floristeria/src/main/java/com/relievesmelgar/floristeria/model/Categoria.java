package com.relievesmelgar.floristeria.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Categorias")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CATEGORIA")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "FOTO")
	private String foto;
	
	@Column(name = "FECHA_CREACION")
	private LocalDate fechaCreacion;
	
	@Column(name = "ESTADO")
	private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_PADRE_CATEGORIA")
    @JsonIgnore
	private Categoria categoriaPadre;
    
    @OneToMany(mappedBy = "categoriaPadre")
    private List<Categoria> subcategorias;
    
    @ManyToMany(mappedBy = "categorias")
    @JsonIgnore
    private List<Producto> productos;

}
