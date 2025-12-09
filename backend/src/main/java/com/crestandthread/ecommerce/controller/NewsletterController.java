// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.controller;

import com.crestandthread.ecommerce.dto.ApiResponse;
import com.crestandthread.ecommerce.dto.NewsletterSubscriptionDTO;
import com.crestandthread.ecommerce.service.NewsletterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for Newsletter operations.
 */
@RestController
@RequestMapping("/api/v1/newsletter")
@RequiredArgsConstructor
@Tag(name = "Newsletter", description = "Newsletter subscription APIs")
public class NewsletterController {

    private final NewsletterService newsletterService;

    /**
     * Request body for newsletter subscription.
     */
    public record SubscribeRequest(
            @NotBlank(message = "Email is required")
            @Email(message = "Please provide a valid email address")
            String email
    ) {}

    @PostMapping("/subscribe")
    @Operation(summary = "Subscribe to newsletter", description = "Subscribe an email to the newsletter")
    public ResponseEntity<ApiResponse<NewsletterSubscriptionDTO>> subscribe(
            @Valid @RequestBody SubscribeRequest request) {
        NewsletterSubscriptionDTO subscription = newsletterService.subscribe(request.email());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Successfully subscribed to newsletter", subscription));
    }

    @PostMapping("/unsubscribe")
    @Operation(summary = "Unsubscribe from newsletter", description = "Unsubscribe an email from the newsletter")
    public ResponseEntity<ApiResponse<Void>> unsubscribe(@Valid @RequestBody SubscribeRequest request) {
        newsletterService.unsubscribe(request.email());
        return ResponseEntity.ok(ApiResponse.success("Successfully unsubscribed from newsletter", null));
    }

    @GetMapping("/check")
    @Operation(summary = "Check subscription status", description = "Check if an email is subscribed")
    public ResponseEntity<ApiResponse<Boolean>> checkSubscription(
            @RequestParam @Email(message = "Please provide a valid email") String email) {
        boolean isSubscribed = newsletterService.isSubscribed(email);
        return ResponseEntity.ok(ApiResponse.success(isSubscribed));
    }
}
// AI Generated Code by Deloitte + Cursor (END)
