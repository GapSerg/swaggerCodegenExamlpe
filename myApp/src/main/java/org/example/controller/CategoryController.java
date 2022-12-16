/*
 *
 *  @Autor GapSerg
 *
 *  @Create 2022-12-11.12.2022 15:25
 *
 **/

package org.example.controller;

import java.util.List;
import org.example.api.CategoriesApi;
import org.example.model.CategoryRequestDto;
import org.example.model.CategoryResponseDto;
import org.example.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoriesApi {

  private final CategoryServiceImpl categoryService;

  public CategoryController(CategoryServiceImpl categoryService) {
    this.categoryService = new CategoryServiceImpl();
  }

  @Override
  public ResponseEntity<Long> createCategory(CategoryRequestDto categoryRequestDto) {

    return new ResponseEntity<>(categoryService.addNewCategory(categoryRequestDto),
        HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteCategoryById(Long categoryId) {

    categoryService.deleteCategory(categoryId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {

    return new ResponseEntity<>(categoryService.getAllCategory(),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<CategoryResponseDto> getCategoryById(Long categoryId) {

    return new ResponseEntity<>(categoryService.getCategoryById(categoryId),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<CategoryResponseDto> updateCategoryById(Long categoryId,
      CategoryRequestDto categoryRequestDto) {
    return new ResponseEntity<>(categoryService.updateCategoryById(categoryId,
        categoryRequestDto),
        HttpStatus.CREATED);
  }
}
