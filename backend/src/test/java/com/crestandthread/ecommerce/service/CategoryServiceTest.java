// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.CategoryDTO;
import com.crestandthread.ecommerce.entity.Category;
import com.crestandthread.ecommerce.exception.DuplicateResourceException;
import com.crestandthread.ecommerce.exception.ResourceNotFoundException;
import com.crestandthread.ecommerce.mapper.CategoryMapper;
import com.crestandthread.ecommerce.repository.CategoryRepository;
import com.crestandthread.ecommerce.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Unit tests for CategoryService.
 */
@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;
    private CategoryDTO categoryDTO;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setId(1L);
        category.setName("Women's Collection");
        category.setSlug("women");
        category.setDescription("Elegant women's apparel");
        category.setActive(true);

        categoryDTO = CategoryDTO.builder()
                .id(1L)
                .name("Women's Collection")
                .slug("women")
                .description("Elegant women's apparel")
                .active(true)
                .build();
    }

    @Nested
    @DisplayName("getAllCategories")
    class GetAllCategories {

        @Test
        @DisplayName("should return all active categories")
        void shouldReturnAllActiveCategories() {
            // Given
            List<Category> categories = Arrays.asList(category);
            when(categoryRepository.findByActiveTrueOrderByDisplayOrderAsc()).thenReturn(categories);
            when(categoryMapper.toDTO(any(Category.class))).thenReturn(categoryDTO);

            // When
            List<CategoryDTO> result = categoryService.getAllCategories();

            // Then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).getName()).isEqualTo("Women's Collection");
            verify(categoryRepository).findByActiveTrueOrderByDisplayOrderAsc();
        }

        @Test
        @DisplayName("should return empty list when no categories exist")
        void shouldReturnEmptyListWhenNoCategoriesExist() {
            // Given
            when(categoryRepository.findByActiveTrueOrderByDisplayOrderAsc()).thenReturn(List.of());

            // When
            List<CategoryDTO> result = categoryService.getAllCategories();

            // Then
            assertThat(result).isEmpty();
        }
    }

    @Nested
    @DisplayName("getCategoryById")
    class GetCategoryById {

        @Test
        @DisplayName("should return category when found")
        void shouldReturnCategoryWhenFound() {
            // Given
            when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
            when(categoryMapper.toDTO(category)).thenReturn(categoryDTO);

            // When
            Optional<CategoryDTO> result = categoryService.getCategoryById(1L);

            // Then
            assertThat(result).isPresent();
            assertThat(result.get().getName()).isEqualTo("Women's Collection");
        }

        @Test
        @DisplayName("should return empty when not found")
        void shouldReturnEmptyWhenNotFound() {
            // Given
            when(categoryRepository.findById(999L)).thenReturn(Optional.empty());

            // When
            Optional<CategoryDTO> result = categoryService.getCategoryById(999L);

            // Then
            assertThat(result).isEmpty();
        }
    }

    @Nested
    @DisplayName("getCategoryBySlug")
    class GetCategoryBySlug {

        @Test
        @DisplayName("should return category when found by slug")
        void shouldReturnCategoryWhenFoundBySlug() {
            // Given
            when(categoryRepository.findBySlug("women")).thenReturn(Optional.of(category));
            when(categoryMapper.toDTO(category)).thenReturn(categoryDTO);

            // When
            Optional<CategoryDTO> result = categoryService.getCategoryBySlug("women");

            // Then
            assertThat(result).isPresent();
            assertThat(result.get().getSlug()).isEqualTo("women");
        }
    }

    @Nested
    @DisplayName("createCategory")
    class CreateCategory {

        @Test
        @DisplayName("should create category successfully")
        void shouldCreateCategorySuccessfully() {
            // Given
            CategoryDTO inputDTO = CategoryDTO.builder()
                    .name("Men's Collection")
                    .build();

            Category newCategory = new Category();
            newCategory.setName("Men's Collection");

            Category savedCategory = new Category();
            savedCategory.setId(2L);
            savedCategory.setName("Men's Collection");
            savedCategory.setSlug("mens-collection");

            CategoryDTO savedDTO = CategoryDTO.builder()
                    .id(2L)
                    .name("Men's Collection")
                    .slug("mens-collection")
                    .build();

            when(categoryRepository.existsBySlug(anyString())).thenReturn(false);
            when(categoryMapper.toEntity(inputDTO)).thenReturn(newCategory);
            when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);
            when(categoryMapper.toDTO(savedCategory)).thenReturn(savedDTO);

            // When
            CategoryDTO result = categoryService.createCategory(inputDTO);

            // Then
            assertThat(result.getId()).isEqualTo(2L);
            assertThat(result.getName()).isEqualTo("Men's Collection");
            verify(categoryRepository).save(any(Category.class));
        }

        @Test
        @DisplayName("should throw exception when slug already exists")
        void shouldThrowExceptionWhenSlugExists() {
            // Given
            CategoryDTO inputDTO = CategoryDTO.builder()
                    .name("Women's Collection")
                    .slug("women")
                    .build();

            when(categoryRepository.existsBySlug("women")).thenReturn(true);

            // When/Then
            assertThatThrownBy(() -> categoryService.createCategory(inputDTO))
                    .isInstanceOf(DuplicateResourceException.class)
                    .hasMessageContaining("already exists");
        }
    }

    @Nested
    @DisplayName("updateCategory")
    class UpdateCategory {

        @Test
        @DisplayName("should update category successfully")
        void shouldUpdateCategorySuccessfully() {
            // Given
            CategoryDTO updateDTO = CategoryDTO.builder()
                    .name("Updated Name")
                    .build();

            when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
            when(categoryRepository.save(any(Category.class))).thenReturn(category);
            when(categoryMapper.toDTO(category)).thenReturn(categoryDTO);

            // When
            CategoryDTO result = categoryService.updateCategory(1L, updateDTO);

            // Then
            verify(categoryMapper).updateEntity(category, updateDTO);
            verify(categoryRepository).save(category);
        }

        @Test
        @DisplayName("should throw exception when category not found")
        void shouldThrowExceptionWhenCategoryNotFound() {
            // Given
            CategoryDTO updateDTO = CategoryDTO.builder()
                    .name("Updated Name")
                    .build();

            when(categoryRepository.findById(999L)).thenReturn(Optional.empty());

            // When/Then
            assertThatThrownBy(() -> categoryService.updateCategory(999L, updateDTO))
                    .isInstanceOf(ResourceNotFoundException.class)
                    .hasMessageContaining("not found");
        }
    }

    @Nested
    @DisplayName("deleteCategory")
    class DeleteCategory {

        @Test
        @DisplayName("should soft delete category")
        void shouldSoftDeleteCategory() {
            // Given
            when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
            when(categoryRepository.save(any(Category.class))).thenReturn(category);

            // When
            categoryService.deleteCategory(1L);

            // Then
            assertThat(category.getActive()).isFalse();
            verify(categoryRepository).save(category);
        }

        @Test
        @DisplayName("should throw exception when category not found")
        void shouldThrowExceptionWhenCategoryNotFound() {
            // Given
            when(categoryRepository.findById(999L)).thenReturn(Optional.empty());

            // When/Then
            assertThatThrownBy(() -> categoryService.deleteCategory(999L))
                    .isInstanceOf(ResourceNotFoundException.class);
        }
    }
}
// AI Generated Code by Deloitte + Cursor (END)
