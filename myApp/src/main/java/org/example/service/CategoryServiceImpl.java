/*
 *
 *  @Autor GapSerg
 *
 *  @Create 2022-12-11.12.2022 15:27
 *
 **/

package org.example.service;

import java.util.ArrayList;
import java.util.List;
import org.example.model.CategoryRequestDto;
import org.example.model.CategoryResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final List<CategoryResponseDto> categories;
  private long idCount;

  public CategoryServiceImpl() {
    categories = new ArrayList<>();
    idCount = 0;
  }

  @Override
  public Long addNewCategory(CategoryRequestDto categoryRequestDto) {
    CategoryResponseDto responseDto = new CategoryResponseDto();
    idCount++;
    responseDto.setId(idCount);
    responseDto.setColor(categoryRequestDto.getColor());
    responseDto.setName(categoryRequestDto.getName());
    categories.add(responseDto);
    return idCount;
  }

  @Override
  public void deleteCategory(Long categoryId) {

    CategoryResponseDto
        categoryResponseDtoForDelete = categories.stream()
        .filter(c -> c.getId() == categoryId)
        .findFirst().orElseThrow();
    categories.remove(categoryResponseDtoForDelete);
  }

  @Override
  public List<CategoryResponseDto> getAllCategory() {
    return categories;
  }

  @Override
  public CategoryResponseDto getCategoryById(Long categoryId) {
    return categories.stream()
        .filter(c -> c.getId() == categoryId)
        .findFirst().orElseThrow();
  }

  @Override
  public CategoryResponseDto updateCategoryById(Long categoryId,
      CategoryRequestDto categoryRequestDto) {
    CategoryResponseDto
        categoryResponseDtoForUpdate = categories.stream()
        .filter(c -> c.getId() == categoryId)
        .findFirst().orElseThrow();

    if (categoryRequestDto.getColor() != null) {
      categoryResponseDtoForUpdate.setColor(categoryRequestDto.getColor());
    }
    if (categoryRequestDto.getName() != null) {
      categoryResponseDtoForUpdate.setName(categoryRequestDto.getName());
    }

    return categoryResponseDtoForUpdate;
  }
}
