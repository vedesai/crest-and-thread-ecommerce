// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.controller;

import com.crestandthread.ecommerce.dto.ProductDTO;
import com.crestandthread.ecommerce.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for ProductController.
 */
@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    private ProductDTO productDTO;

    @BeforeEach
    void setUp() {
        productDTO = ProductDTO.builder()
                .id(1L)
                .sku("CT-KW-001")
                .name("Cashmere Crew Sweater")
                .description("Luxuriously soft cashmere sweater")
                .price(new BigDecimal("189.00"))
                .categoryId(1L)
                .categoryName("Knitwear")
                .active(true)
                .isNew(true)
                .isFeatured(true)
                .build();
    }

    @Nested
    @DisplayName("GET /api/v1/products")
    class GetAllProducts {

        @Test
        @DisplayName("should return paginated products")
        void shouldReturnPaginatedProducts() throws Exception {
            // Given
            Page<ProductDTO> productPage = new PageImpl<>(Arrays.asList(productDTO), PageRequest.of(0, 12), 1);
            when(productService.getAllProducts(any())).thenReturn(productPage);

            // When/Then
            mockMvc.perform(get("/api/v1/products"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data.content").isArray())
                    .andExpect(jsonPath("$.data.content[0].name").value("Cashmere Crew Sweater"));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/products/{id}")
    class GetProductById {

        @Test
        @DisplayName("should return product when found")
        void shouldReturnProductWhenFound() throws Exception {
            // Given
            when(productService.getProductById(1L)).thenReturn(Optional.of(productDTO));

            // When/Then
            mockMvc.perform(get("/api/v1/products/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data.name").value("Cashmere Crew Sweater"));
        }

        @Test
        @DisplayName("should return 404 when not found")
        void shouldReturn404WhenNotFound() throws Exception {
            // Given
            when(productService.getProductById(999L)).thenReturn(Optional.empty());

            // When/Then
            mockMvc.perform(get("/api/v1/products/999"))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.success").value(false));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/products/new-arrivals")
    class GetNewArrivals {

        @Test
        @DisplayName("should return new arrival products")
        void shouldReturnNewArrivalProducts() throws Exception {
            // Given
            List<ProductDTO> products = Arrays.asList(productDTO);
            when(productService.getNewArrivals()).thenReturn(products);

            // When/Then
            mockMvc.perform(get("/api/v1/products/new-arrivals"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data").isArray())
                    .andExpect(jsonPath("$.data[0].isNew").value(true));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/products/featured")
    class GetFeaturedProducts {

        @Test
        @DisplayName("should return featured products")
        void shouldReturnFeaturedProducts() throws Exception {
            // Given
            List<ProductDTO> products = Arrays.asList(productDTO);
            when(productService.getFeaturedProducts()).thenReturn(products);

            // When/Then
            mockMvc.perform(get("/api/v1/products/featured"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data").isArray())
                    .andExpect(jsonPath("$.data[0].isFeatured").value(true));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/products/category/{categorySlug}")
    class GetProductsByCategory {

        @Test
        @DisplayName("should return products by category")
        void shouldReturnProductsByCategory() throws Exception {
            // Given
            Page<ProductDTO> productPage = new PageImpl<>(Arrays.asList(productDTO), PageRequest.of(0, 12), 1);
            when(productService.getProductsByCategory(any(), any())).thenReturn(productPage);

            // When/Then
            mockMvc.perform(get("/api/v1/products/category/knitwear"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data.content[0].categoryName").value("Knitwear"));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/products/search")
    class SearchProducts {

        @Test
        @DisplayName("should search products by query")
        void shouldSearchProductsByQuery() throws Exception {
            // Given
            Page<ProductDTO> productPage = new PageImpl<>(Arrays.asList(productDTO), PageRequest.of(0, 12), 1);
            when(productService.searchProducts(any(), any())).thenReturn(productPage);

            // When/Then
            mockMvc.perform(get("/api/v1/products/search")
                            .param("q", "cashmere"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.data.content").isArray());
        }
    }

    @Nested
    @DisplayName("POST /api/v1/products")
    class CreateProduct {

        @Test
        @DisplayName("should create product successfully")
        void shouldCreateProductSuccessfully() throws Exception {
            // Given
            ProductDTO inputDTO = ProductDTO.builder()
                    .sku("CT-KW-002")
                    .name("New Product")
                    .price(new BigDecimal("99.00"))
                    .categoryId(1L)
                    .build();

            when(productService.createProduct(any(ProductDTO.class))).thenReturn(productDTO);

            // When/Then
            mockMvc.perform(post("/api/v1/products")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(inputDTO)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.success").value(true));
        }

        @Test
        @DisplayName("should return 400 when SKU is blank")
        void shouldReturn400WhenSkuIsBlank() throws Exception {
            // Given
            ProductDTO inputDTO = ProductDTO.builder()
                    .sku("")
                    .name("New Product")
                    .price(new BigDecimal("99.00"))
                    .categoryId(1L)
                    .build();

            // When/Then
            mockMvc.perform(post("/api/v1/products")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(inputDTO)))
                    .andExpect(status().isBadRequest());
        }
    }

    @Nested
    @DisplayName("DELETE /api/v1/products/{id}")
    class DeleteProduct {

        @Test
        @DisplayName("should delete product successfully")
        void shouldDeleteProductSuccessfully() throws Exception {
            // When/Then
            mockMvc.perform(delete("/api/v1/products/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true));
        }
    }
}
// AI Generated Code by Deloitte + Cursor (END)
