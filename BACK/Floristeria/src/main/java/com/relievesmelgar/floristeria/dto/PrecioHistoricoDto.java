package com.relievesmelgar.floristeria.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrecioHistoricoDto {
    private Long id;
    private Double precio;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
