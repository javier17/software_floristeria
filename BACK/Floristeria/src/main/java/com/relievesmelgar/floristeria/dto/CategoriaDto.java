package com.relievesmelgar.floristeria.dto;

import java.time.LocalDate;
import java.util.List;

import com.relievesmelgar.floristeria.model.Categoria;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String foto;
	
	private LocalDate fechaCreacion;
	
	private Boolean estado;

	private Long categoriaPadre;
    
    private List<Categoria> subcategorias;

    public static CategoriaDto toDto(Categoria entity) {
    	CategoriaDto dto = new CategoriaDto();
    	dto.setId(entity.getId());
    	dto.setNombre(entity.getNombre());
    	dto.setDescripcion(entity.getDescripcion());
    	dto.setFoto(entity.getFoto());
    	dto.setFechaCreacion(entity.getFechaCreacion());
    	dto.setEstado(entity.getEstado());
    	dto.setCategoriaPadre(entity.getId());
    	return dto;
    }
    
}