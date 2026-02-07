package com.relievesmelgar.floristeria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.relievesmelgar.floristeria.model.Categoria;
import com.relievesmelgar.floristeria.model.PrecioProducto;
import com.relievesmelgar.floristeria.model.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
	
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private String foto;
    private Boolean estado;
    private List<Long> categoriasIds;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private BigDecimal precio;
    
    
    public static ProductoDto toDto(Producto producto){
    	ProductoDto dto = new ProductoDto();
    	dto.setIdProducto(producto.getIdProducto());
    	dto.setNombre(producto.getNombre());
    	dto.setDescripcion(producto.getDescripcion());
    	dto.setFoto(producto.getFoto());
    	dto.setEstado(producto.getEstado());
    	dto.setFechaActualizacion(producto.getFechaCreacion());
    	dto.setFechaActualizacion(producto.getFechaActualizacion());
    	dto.setCategoriasIds(
    		    producto.getCategorias()
    		        .stream()
    		        .map(Categoria::getId)
    		        .collect(Collectors.toList())
    		);    	
    	PrecioProducto precioActual =
    		    producto.getPrecios()
    		        .stream()
    		        .filter(p -> p.getFechaFin() == null)
    		        .max(Comparator.comparing(PrecioProducto::getFechaInicio))
    		        .orElse(null);  			
    	dto.setPrecio(precioActual.getPrecio());    	
    	return dto;
    }
    
}
