package com.jayptl.learningjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    
    private long id;
    private String productName;
    private String productDescription;
    private long price;
    private String category;
}
