package org.mcs.productv2service.service;

import lombok.RequiredArgsConstructor;
import org.mcs.productv2service.dto.ProductRequestDto;
import org.mcs.productv2service.dto.ProductResponseDto;
import org.mcs.productv2service.dto.UpdateProductRequestDto;
import org.mcs.productv2service.exception.ExceptionMessage;
import org.mcs.productv2service.exception.RestException;
import org.mcs.productv2service.mapper.CrudProductMapper;
import org.mcs.productv2service.model.ProductEntity;
import org.mcs.productv2service.repository.ProductEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {


    private final ProductEntityRepository productEntityRepository;


    private final CrudProductMapper crudProductMapper;


    @Override
    public ProductResponseDto getProductById(Long productId) {
        ProductEntity product = getProductOrElseThrow(productId);
        ProductResponseDto productResponseDto = crudProductMapper.mapProductToProductResponseDto(product);
        return productResponseDto;

    }

    @Override
    public List<ProductResponseDto> getProductsByIds(List<Long> productIds) {
        List<ProductEntity> productEntities = productEntityRepository.findAllById(productIds);
        if (productEntities.isEmpty()) {
            throw new RestException(ExceptionMessage.NULL_POINTER.getMessage());
        }
        List<ProductResponseDto> productResponseDtos = crudProductMapper.mapProductsToProductResponses(productEntities);
        return productResponseDtos;
    }

    @Override
    @Transactional
    public void createProduct(ProductRequestDto productRequestDto) {
        ProductEntity product = crudProductMapper.mapProductRequestDtoToProductEntity(productRequestDto);
        productEntityRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(UpdateProductRequestDto updateProductRequestDto) {
        ProductEntity product = getProductOrElseThrow(updateProductRequestDto.getProductId());
        crudProductMapper.updateProduct(product, updateProductRequestDto);
        productEntityRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProductById(Long productId) {
        ProductEntity product = getProductOrElseThrow(productId);
        productEntityRepository.delete(product);
    }

    @Override
    @Transactional
    public void deleteProductsByIds(List<Long> productIds) {
        List<ProductEntity> productEntities = productEntityRepository.findAllById(productIds);
        if (productEntities.isEmpty()) {
            throw new RestException(ExceptionMessage.NULL_POINTER.getMessage());
        }
        productEntityRepository.deleteAll(productEntities);
    }

    private ProductEntity getProductOrElseThrow(Long productId) {
        return productEntityRepository.findById(productId)
                .orElseThrow(() -> new RestException(ExceptionMessage.NULL_POINTER.getMessage(), productId));
    }
}
