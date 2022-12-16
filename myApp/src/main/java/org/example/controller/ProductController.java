/*
 *
 *  @Autor GapSerg
 *
 *  @Create 2022-12-11.12.2022 17:23
 *
 **/

package org.example.controller;

import java.util.List;
import org.example.api.ProductsApi;
import org.example.model.ProductResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ProductController implements ProductsApi {
  @Override
  public ResponseEntity<List<ProductResponseDto>> createProduct() {
    return null;
  }

  @Override
  public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
    ProductResponseDto product = new ProductResponseDto();
    product.setName("tee");
    List<ProductResponseDto> productResponseDtos = List.of(product);
    return new ResponseEntity<>(productResponseDtos, HttpStatus.OK);
  }
}
