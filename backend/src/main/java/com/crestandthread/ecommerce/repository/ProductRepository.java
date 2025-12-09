// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.repository;

import com.crestandthread.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Find product by SKU.
     */
    Optional<Product> findBySku(String sku);

    /**
     * Find all active products.
     */
    List<Product> findByActiveTrue();

    /**
     * Find all active products with pagination.
     */
    Page<Product> findByActiveTrue(Pageable pageable);

    /**
     * Find new arrival products.
     */
    List<Product> findByActiveTrueAndIsNewTrueOrderByCreatedAtDesc();

    /**
     * Find featured products.
     */
    List<Product> findByActiveTrueAndIsFeaturedTrueOrderByCreatedAtDesc();

    /**
     * Find products by category slug.
     */
    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.slug = :categorySlug AND p.active = true")
    Page<Product> findByCategorySlug(@Param("categorySlug") String categorySlug, Pageable pageable);

    /**
     * Find products by category ID.
     */
    List<Product> findByCategoryIdAndActiveTrue(Long categoryId);

    /**
     * Find products on sale.
     */
    @Query("SELECT p FROM Product p WHERE p.active = true AND p.salePrice IS NOT NULL AND p.salePrice < p.price ORDER BY p.createdAt DESC")
    List<Product> findOnSaleProducts();

    /**
     * Search products by name.
     */
    @Query("SELECT p FROM Product p WHERE p.active = true AND LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    Page<Product> searchByName(@Param("query") String query, Pageable pageable);

    /**
     * Check if SKU exists.
     */
    boolean existsBySku(String sku);
}
// AI Generated Code by Deloitte + Cursor (END)
