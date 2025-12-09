// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.controller;

import com.crestandthread.ecommerce.dto.CategoryDTO;
import com.crestandthread.ecommerce.exception.ResourceNotFoundException;
import com.crestandthread.ecommerce.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for CategoryController.
 */
@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc(addFilters = false)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    private CategoryDTO categoryDTO;

    @BeforeEach
    void setUp() {
        categoryDTO = CategoryDTO.builder()
                .id(1L)
                .name("Women's Collection")
                .slug("women")
                .description("Elegant women's apparel")
                .active(true)
                .productCount(256)
                .build();
    }

    @Nested
    @DisplayName("GET /api/v1/categories")
    class GetAllCategories {

        @Test
        @DisplayName("should return all categories")
        void shouldReturnAllCategories() throws Exception {
            // Given
            List<CategoryDTO> categories = Arrays.asList(categoryDTO);
            when(categoryService.getAllCategories()).thenReturn(categories);

            // When/Then
            mockMvc.perform(get("/api/v1/categories"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data").isArray())
                    .andExpect(jsonPath("$.data[0].name").value("Women's Collection"));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/categories/{id}")
    class GetCategoryById {

        @Test
        @DisplayName("should return category when found")
        void shouldReturnCategoryWhenFound() throws Exception {
            // Given
            when(categoryService.getCategoryById(1L)).thenReturn(Optional.of(categoryDTO));

            // When/Then
            mockMvc.perform(get("/api/v1/categories/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data.name").value("Women's Collection"));
        }

        @Test
        @DisplayName("should return 404 when not found")
        void shouldReturn404WhenNotFound() throws Exception {
            // Given
            when(categoryService.getCategoryById(999L)).thenReturn(Optional.empty());

            // When/Then
            mockMvc.perform(get("/api/v1/categories/999"))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.success").value(false));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/categories/slug/{slug}")
    class GetCategoryBySlug {

        @Test
        @DisplayName("should return category when found by slug")
        void shouldReturnCategoryWhenFoundBySlug() throws Exception {
            // Given
            when(categoryService.getCategoryBySlug("women")).thenReturn(Optional.of(categoryDTO));

            // When/Then
            mockMvc.perform(get("/api/v1/categories/slug/women"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data.slug").value("women"));
        }
    }

    @Nested
    @DisplayName("POST /api/v1/categories")
    class CreateCategory {

        @Test
        @DisplayName("should create category successfully")
        void shouldCreateCategorySuccessfully() throws Exception {
            // Given
            CategoryDTO inputDTO = CategoryDTO.builder()
                    .name("Men's Collection")
                    .description("Classic men's fashion")
                    .build();

            CategoryDTO createdDTO = CategoryDTO.builder()
                    .id(2L)
                    .name("Men's Collection")
                    .slug("mens-collection")
                    .description("Classic men's fashion")
                    .active(true)
                    .build();

            when(categoryService.createCategory(any(CategoryDTO.class))).thenReturn(createdDTO);

            // When/Then
            mockMvc.perform(post("/api/v1/categories")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(inputDTO)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data.id").value(2L));
        }

        @Test
        @DisplayName("should return 400 when name is blank")
        void shouldReturn400WhenNameIsBlank() throws Exception {
            // Given
            CategoryDTO inputDTO = CategoryDTO.builder()
                    .name("")
                    .build();

            // When/Then
            mockMvc.perform(post("/api/v1/categories")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(inputDTO)))
                    .andExpect(status().isBadRequest());
        }
    }

    @Nested
    @DisplayName("PUT /api/v1/categories/{id}")
    class UpdateCategory {

        @Test
        @DisplayName("should update category successfully")
        void shouldUpdateCategorySuccessfully() throws Exception {
            // Given
            CategoryDTO updateDTO = CategoryDTO.builder()
                    .name("Updated Name")
                    .build();

            when(categoryService.updateCategory(eq(1L), any(CategoryDTO.class))).thenReturn(categoryDTO);

            // When/Then
            mockMvc.perform(put("/api/v1/categories/1")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(updateDTO)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true));
        }
    }

    @Nested
    @DisplayName("DELETE /api/v1/categories/{id}")
    class DeleteCategory {

        @Test
        @DisplayName("should delete category successfully")
        void shouldDeleteCategorySuccessfully() throws Exception {
            // When/Then
            mockMvc.perform(delete("/api/v1/categories/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true));
        }
    }
}
// AI Generated Code by Deloitte + Cursor (END)
