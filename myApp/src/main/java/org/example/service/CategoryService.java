/*
 *
 *  @Autor GapSerg
 *
 *  @Create 2022-12-11.12.2022 15:34
 *
 **/

package org.example.service;

import java.util.List;
import org.example.model.CategoryRequestDto;
import org.example.model.CategoryResponseDto;

public interface CategoryService {

  Long addNewCategory(CategoryRequestDto categoryRequestDto);

  void deleteCategory(Long categoryId);

  List<CategoryResponseDto> getAllCategory();

  CategoryResponseDto getCategoryById(Long categoryId);

  CategoryResponseDto updateCategoryById(Long categoryId, CategoryRequestDto categoryRequestDto);


}
