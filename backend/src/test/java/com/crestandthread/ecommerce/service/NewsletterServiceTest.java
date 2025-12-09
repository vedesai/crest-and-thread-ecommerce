// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.NewsletterSubscriptionDTO;
import com.crestandthread.ecommerce.entity.NewsletterSubscription;
import com.crestandthread.ecommerce.exception.DuplicateResourceException;
import com.crestandthread.ecommerce.exception.ResourceNotFoundException;
import com.crestandthread.ecommerce.mapper.NewsletterMapper;
import com.crestandthread.ecommerce.repository.NewsletterSubscriptionRepository;
import com.crestandthread.ecommerce.service.impl.NewsletterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit tests for NewsletterService.
 */
@ExtendWith(MockitoExtension.class)
class NewsletterServiceTest {

    @Mock
    private NewsletterSubscriptionRepository subscriptionRepository;

    @Mock
    private NewsletterMapper newsletterMapper;

    @InjectMocks
    private NewsletterServiceImpl newsletterService;

    private NewsletterSubscription subscription;
    private NewsletterSubscriptionDTO subscriptionDTO;

    @BeforeEach
    void setUp() {
        subscription = new NewsletterSubscription();
        subscription.setId(1L);
        subscription.setEmail("test@example.com");
        subscription.setActive(true);
        subscription.setSubscribedAt(LocalDateTime.now());

        subscriptionDTO = NewsletterSubscriptionDTO.builder()
                .id(1L)
                .email("test@example.com")
                .active(true)
                .subscribedAt(LocalDateTime.now())
                .build();
    }

    @Nested
    @DisplayName("subscribe")
    class Subscribe {

        @Test
        @DisplayName("should subscribe new email successfully")
        void shouldSubscribeNewEmailSuccessfully() {
            // Given
            String email = "new@example.com";
            when(subscriptionRepository.existsByEmailAndActiveTrue(email)).thenReturn(false);
            when(subscriptionRepository.findByEmail(email)).thenReturn(Optional.empty());
            when(subscriptionRepository.save(any(NewsletterSubscription.class))).thenReturn(subscription);
            when(newsletterMapper.toDTO(subscription)).thenReturn(subscriptionDTO);

            // When
            NewsletterSubscriptionDTO result = newsletterService.subscribe(email);

            // Then
            assertThat(result).isNotNull();
            verify(subscriptionRepository).save(any(NewsletterSubscription.class));
        }

        @Test
        @DisplayName("should reactivate existing inactive subscription")
        void shouldReactivateExistingInactiveSubscription() {
            // Given
            String email = "inactive@example.com";
            NewsletterSubscription inactiveSubscription = new NewsletterSubscription();
            inactiveSubscription.setEmail(email);
            inactiveSubscription.setActive(false);

            when(subscriptionRepository.existsByEmailAndActiveTrue(email)).thenReturn(false);
            when(subscriptionRepository.findByEmail(email)).thenReturn(Optional.of(inactiveSubscription));
            when(subscriptionRepository.save(any(NewsletterSubscription.class))).thenReturn(subscription);
            when(newsletterMapper.toDTO(subscription)).thenReturn(subscriptionDTO);

            // When
            NewsletterSubscriptionDTO result = newsletterService.subscribe(email);

            // Then
            assertThat(inactiveSubscription.getActive()).isTrue();
            verify(subscriptionRepository).save(inactiveSubscription);
        }

        @Test
        @DisplayName("should throw exception when email already subscribed")
        void shouldThrowExceptionWhenEmailAlreadySubscribed() {
            // Given
            String email = "active@example.com";
            when(subscriptionRepository.existsByEmailAndActiveTrue(email)).thenReturn(true);

            // When/Then
            assertThatThrownBy(() -> newsletterService.subscribe(email))
                    .isInstanceOf(DuplicateResourceException.class)
                    .hasMessageContaining("already exists");
        }
    }

    @Nested
    @DisplayName("unsubscribe")
    class Unsubscribe {

        @Test
        @DisplayName("should unsubscribe email successfully")
        void shouldUnsubscribeEmailSuccessfully() {
            // Given
            String email = "test@example.com";
            when(subscriptionRepository.findByEmail(email)).thenReturn(Optional.of(subscription));
            when(subscriptionRepository.save(any(NewsletterSubscription.class))).thenReturn(subscription);

            // When
            newsletterService.unsubscribe(email);

            // Then
            assertThat(subscription.getActive()).isFalse();
            verify(subscriptionRepository).save(subscription);
        }

        @Test
        @DisplayName("should throw exception when email not found")
        void shouldThrowExceptionWhenEmailNotFound() {
            // Given
            String email = "notfound@example.com";
            when(subscriptionRepository.findByEmail(email)).thenReturn(Optional.empty());

            // When/Then
            assertThatThrownBy(() -> newsletterService.unsubscribe(email))
                    .isInstanceOf(ResourceNotFoundException.class);
        }
    }

    @Nested
    @DisplayName("isSubscribed")
    class IsSubscribed {

        @Test
        @DisplayName("should return true when email is subscribed")
        void shouldReturnTrueWhenEmailIsSubscribed() {
            // Given
            String email = "test@example.com";
            when(subscriptionRepository.existsByEmailAndActiveTrue(email)).thenReturn(true);

            // When
            boolean result = newsletterService.isSubscribed(email);

            // Then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("should return false when email is not subscribed")
        void shouldReturnFalseWhenEmailIsNotSubscribed() {
            // Given
            String email = "notsubscribed@example.com";
            when(subscriptionRepository.existsByEmailAndActiveTrue(email)).thenReturn(false);

            // When
            boolean result = newsletterService.isSubscribed(email);

            // Then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("getSubscriptionCount")
    class GetSubscriptionCount {

        @Test
        @DisplayName("should return active subscription count")
        void shouldReturnActiveSubscriptionCount() {
            // Given
            when(subscriptionRepository.countByActiveTrue()).thenReturn(100L);

            // When
            long result = newsletterService.getSubscriptionCount();

            // Then
            assertThat(result).isEqualTo(100L);
        }
    }
}
// AI Generated Code by Deloitte + Cursor (END)
