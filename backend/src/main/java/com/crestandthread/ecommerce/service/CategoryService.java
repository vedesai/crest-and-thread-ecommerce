// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.CategoryDTO;
import com.crestandthread.ecommerce.entity.Category;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for Category operations.
 */
public interface CategoryService {

    /**
     * Get all active categories.
     */
    List<CategoryDTO> getAllCategories();

    /**
     * Get category by ID.
     */
    Optional<CategoryDTO> getCategoryById(Long id);

    /**
     * Get category by slug.
     */
    Optional<CategoryDTO> getCategoryBySlug(String slug);

    /**
     * Create a new category.
     */
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    /**
     * Update an existing category.
     */
    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    /**
     * Delete a category (soft delete).
     */
    void deleteCategory(Long id);

    /**
     * Get all categories with product counts.
     */
    List<CategoryDTO> getAllCategoriesWithProductCount();
}
// AI Generated Code by Deloitte + Cursor (END)
