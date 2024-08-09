package org.mcs.productv2service.service;

import org.mcs.productv2service.dto.ProductRequestDto;
import org.mcs.productv2service.dto.ProductResponseDto;
import org.mcs.productv2service.dto.UpdateProductRequestDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProductById(Long productId);

    List<ProductResponseDto> getProductsByIds(List<Long> productIds);

    void createProduct(ProductRequestDto productRequestDto);

    void updateProduct(UpdateProductRequestDto updateProductRequestDto);

    void deleteProductById(Long productId);

    void deleteProductsByIds(List<Long> productIds);

}
