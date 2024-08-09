package org.mcs.productv2service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.mcs.productv2service.dto.ProductRequestDto;
import org.mcs.productv2service.dto.ProductResponseDto;
import org.mcs.productv2service.dto.UpdateProductRequestDto;
import org.mcs.productv2service.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get/{productId}")
    @Operation(summary = "get product by id")
    public ProductResponseDto getProductById(@Parameter(description = "product id") @PathVariable("productId") Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/get/all/{productIds}")
    @Operation(summary = "get all products by ids")
    public List<ProductResponseDto> getProductsByIds(@Parameter(description = "products ids") @PathVariable("productIds") List<Long> productIds) {
        return productService.getProductsByIds(productIds);
    }

    @PostMapping("/create")
    @Operation(summary = "create product")
    public void createProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.createProduct(productRequestDto);
    }

    @PutMapping("/update")
    @Operation(summary = "update product")
    public void updateProduct(@RequestBody UpdateProductRequestDto updateProductRequestDto) {
        productService.updateProduct(updateProductRequestDto);
    }

    @DeleteMapping("/delete/{productId}")
    @Operation(summary = "delete product by id")
    public void deleteProduct(@Parameter(description = "product id") @PathVariable("productId") Long productId) {
        productService.deleteProductById(productId);
    }

    @DeleteMapping("/delete/all/{productsIds}")
    @Operation(summary = "delete all products by id")
    public void deleteAllProductsByIds(@Parameter(description = "products ids") @PathVariable("productsIds") List<Long> productsIds) {
        productService.deleteProductsByIds(productsIds);
    }

}
