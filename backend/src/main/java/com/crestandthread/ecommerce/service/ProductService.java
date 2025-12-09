// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for Product operations.
 */
public interface ProductService {

    /**
     * Get all products with pagination.
     */
    Page<ProductDTO> getAllProducts(Pageable pageable);

    /**
     * Get product by ID.
     */
    Optional<ProductDTO> getProductById(Long id);

    /**
     * Get product by SKU.
     */
    Optional<ProductDTO> getProductBySku(String sku);

    /**
     * Get new arrival products.
     */
    List<ProductDTO> getNewArrivals();

    /**
     * Get featured products.
     */
    List<ProductDTO> getFeaturedProducts();

    /**
     * Get products by category slug.
     */
    Page<ProductDTO> getProductsByCategory(String categorySlug, Pageable pageable);

    /**
     * Get products on sale.
     */
    List<ProductDTO> getOnSaleProducts();

    /**
     * Search products by name.
     */
    Page<ProductDTO> searchProducts(String query, Pageable pageable);

    /**
     * Create a new product.
     */
    ProductDTO createProduct(ProductDTO productDTO);

    /**
     * Update an existing product.
     */
    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    /**
     * Delete a product (soft delete).
     */
    void deleteProduct(Long id);
}
// AI Generated Code by Deloitte + Cursor (END)
