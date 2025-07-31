package com.informatorio.info_market.dto.producto; 

import lombok.Data; 
import java.math.BigDecimal;
import java.time.LocalDate; 


@Data 
public class ProductoEnCarritoAbiertoDTO {
    private String id; 
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private LocalDate fechaCreacion; 
    private LocalDate fechaActualizacion; 

    
}  

