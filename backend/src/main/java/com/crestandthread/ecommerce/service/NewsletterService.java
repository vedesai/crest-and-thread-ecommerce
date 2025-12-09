// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.NewsletterSubscriptionDTO;

/**
 * Service interface for Newsletter operations.
 */
public interface NewsletterService {

    /**
     * Subscribe to newsletter.
     */
    NewsletterSubscriptionDTO subscribe(String email);

    /**
     * Unsubscribe from newsletter.
     */
    void unsubscribe(String email);

    /**
     * Check if email is subscribed.
     */
    boolean isSubscribed(String email);

    /**
     * Get subscription count.
     */
    long getSubscriptionCount();
}
// AI Generated Code by Deloitte + Cursor (END)
