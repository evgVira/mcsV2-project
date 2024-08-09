package org.mcs.productv2service.mapper;

import org.mapstruct.*;
import org.mcs.productv2service.dto.ProductRequestDto;
import org.mcs.productv2service.dto.ProductResponseDto;
import org.mcs.productv2service.dto.UpdateProductRequestDto;
import org.mcs.productv2service.model.ProductEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Mapper(componentModel = "spring", imports = {Instant.class, BigDecimal.class})
public interface CrudProductMapper {

    @Mapping(target = "createdDt", defaultExpression = "java(Instant.now().toString())", dateFormat = "dd/mm/yy/hh/mm/ss")
    @Mapping(target = "updatedDt", defaultExpression = "java(Instant.now().toString())", dateFormat = "dd/mm/yy/hh/mm/ss")
    ProductResponseDto mapProductToProductResponseDto(ProductEntity product);

    @InheritConfiguration
    List<ProductResponseDto> mapProductsToProductResponses(List<ProductEntity> productEntities);

    @Mapping(target = "createdDt", expression = "java(Instant.now())", dateFormat = "dd/mm/yy/hh/mm/ss")
    @Mapping(target = "updatedDt", expression = "java(Instant.now())", dateFormat = "dd/mm/yy/hh/mm/ss")
    ProductEntity mapProductRequestDtoToProductEntity(ProductRequestDto productRequestDto);

    @Mapping(target = "productName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "productDescription", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "updatedDt", expression = "java(Instant.now())", dateFormat = "dd/mm/yy/hh/mm/ss")
    ProductEntity updateProduct(@MappingTarget ProductEntity product, UpdateProductRequestDto updateProductRequestDto);

}
