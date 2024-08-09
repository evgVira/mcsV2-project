package org.mcs.productv2service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {

    private Long productId;

    private String productName;

    private String productDescription;

    private String createdDt;

    private String updatedDt;

}
