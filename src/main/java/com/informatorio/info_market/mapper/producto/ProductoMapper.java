package com.informatorio.info_market.mapper.producto;

import com.informatorio.info_market.domain.Categoria;
import com.informatorio.info_market.domain.Producto;
import com.informatorio.info_market.dto.producto.ProductoCreateDto;
import com.informatorio.info_market.dto.producto.ProductoDto;
import com.informatorio.info_market.dto.producto.ProductoEnCarritoAbiertoDTO;
import com.informatorio.info_market.exception.notfound.NotFoundException;
import com.informatorio.info_market.repository.categoria.CategoriaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductoMapper {

    @Autowired
    protected CategoriaRepository categoriaRepository;

    public abstract ProductoDto productoToProductoDto(Producto producto);

    @Mapping(target = "categorias", source = "categorias")
    public abstract Producto productoCreateDtoToProducto(ProductoCreateDto productoCreateDto);

    protected Categoria map(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro la categoria con id : " + id));
    }

    /**
     * Mapea una entidad Producto a un ProductoEnCarritoAbiertoDTO.
     * Añadido @Mapping para mapear 'fechaDeCreacion' de la entidad a 'fechaCreacion' del DTO.
     */
    @Mapping(target = "fechaCreacion", source = "fechaDeCreacion") // <-- ¡Añadida esta línea!
    public abstract ProductoEnCarritoAbiertoDTO toProductoEnCarritoAbiertoDTO(Producto producto);

    /**
     * Mapea una lista de entidades Producto a una lista de ProductoEnCarritoAbiertoDTO.
     */
    public abstract List<ProductoEnCarritoAbiertoDTO> toProductoEnCarritoAbiertoDTOList(List<Producto> productos);
}
