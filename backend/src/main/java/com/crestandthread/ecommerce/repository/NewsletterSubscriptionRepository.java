// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.repository;

import com.crestandthread.ecommerce.entity.NewsletterSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for NewsletterSubscription entity.
 */
@Repository
public interface NewsletterSubscriptionRepository extends JpaRepository<NewsletterSubscription, Long> {

    /**
     * Find subscription by email.
     */
    Optional<NewsletterSubscription> findByEmail(String email);

    /**
     * Check if email is already subscribed.
     */
    boolean existsByEmailAndActiveTrue(String email);

    /**
     * Check if email exists in the system.
     */
    boolean existsByEmail(String email);

    /**
     * Count active subscriptions.
     */
    long countByActiveTrue();
}
// AI Generated Code by Deloitte + Cursor (END)
