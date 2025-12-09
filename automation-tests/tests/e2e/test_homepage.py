# AI Generated Code by Deloitte + Cursor (BEGIN)
"""
E2E Tests for Crest & Thread Home Page

User Story: Navigation Header
As a customer, I want to see a navigation header with the brand logo and menu options,
so that I can easily navigate to different sections of the website.
"""
import pytest
import sys
import os
sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))
from pages.home_page import HomePage


@pytest.mark.homepage
@pytest.mark.smoke
class TestNavigationHeader:
    """Test suite for Navigation Header (Story 1)."""
    
    def test_logo_is_displayed(self, driver, base_url):
        """
        Given I am on any page
        When the page loads
        Then I should see the "Crest & Thread" logo in the header
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        assert home_page.is_logo_displayed(), "Logo should be displayed"
    
    def test_navigation_links_displayed(self, driver, base_url):
        """
        Given I am on any page
        When I view the header
        Then I should see navigation links: New Arrivals, Men, Women, Collections, Sale
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        assert home_page.is_displayed(HomePage.NAV_NEW_ARRIVALS), "New Arrivals link should be displayed"
        assert home_page.is_displayed(HomePage.NAV_MEN), "Men link should be displayed"
        assert home_page.is_displayed(HomePage.NAV_WOMEN), "Women link should be displayed"
        assert home_page.is_displayed(HomePage.NAV_COLLECTIONS), "Collections link should be displayed"
        assert home_page.is_displayed(HomePage.NAV_SALE), "Sale link should be displayed"
    
    def test_header_icons_displayed(self, driver, base_url):
        """
        Given I am on any page
        When I view the header
        Then I should see search, account, and cart icons
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        assert home_page.is_displayed(HomePage.SEARCH_BUTTON), "Search button should be displayed"
        assert home_page.is_displayed(HomePage.ACCOUNT_BUTTON), "Account button should be displayed"
        assert home_page.is_displayed(HomePage.CART_BUTTON), "Cart button should be displayed"
    
    def test_cart_count_badge_displayed(self, driver, base_url):
        """
        Given I view the cart icon
        When there are items in cart
        Then I should see a badge with the item count
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        cart_count = home_page.get_cart_count()
        assert cart_count == "0", f"Cart count should be 0, got {cart_count}"


@pytest.mark.homepage
@pytest.mark.smoke
class TestHeroSection:
    """Test suite for Hero Section (Story 2)."""
    
    def test_hero_section_displayed(self, driver, base_url):
        """
        Given I am on the home page
        When the page loads
        Then I should see a full-width hero section with background image
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        assert home_page.is_hero_displayed(), "Hero section should be displayed"
        assert home_page.is_hero_image_displayed(), "Hero image should be displayed"
    
    def test_hero_collection_label(self, driver, base_url):
        """
        Given I view the hero section
        When it renders
        Then I should see "Winter Collection 2025" label
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        assert home_page.is_displayed(HomePage.HERO_LABEL), "Winter Collection 2025 label should be displayed"
    
    def test_hero_headline(self, driver, base_url):
        """
        Given I view the hero section
        When it renders
        Then I should see the headline "Timeless Elegance Meets Modern Craftsmanship"
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        heading = home_page.get_hero_heading_text()
        assert "Timeless Elegance" in heading, f"Hero heading should contain 'Timeless Elegance', got: {heading}"
    
    def test_hero_cta_buttons(self, driver, base_url):
        """
        Given I view the hero section
        When I see the CTA buttons
        Then I should see "Shop Now" and "Explore Collections" buttons
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        assert home_page.is_displayed(HomePage.SHOP_NOW_BUTTON), "Shop Now button should be displayed"
        assert home_page.is_displayed(HomePage.EXPLORE_COLLECTIONS_BUTTON), "Explore Collections button should be displayed"


@pytest.mark.homepage
@pytest.mark.products
class TestNewArrivalsSection:
    """Test suite for New Arrivals Section (Story 3)."""
    
    def test_new_arrivals_section_displayed(self, driver, base_url):
        """
        Given I am on the home page
        When I scroll to New Arrivals
        Then I should see "Curated Selection" label and "New Arrivals" heading
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_new_arrivals()
        
        assert home_page.is_displayed(HomePage.NEW_ARRIVALS_LABEL), "Curated Selection label should be displayed"
        assert home_page.is_displayed(HomePage.NEW_ARRIVALS_HEADING), "New Arrivals heading should be displayed"
    
    def test_four_product_cards_displayed(self, driver, base_url):
        """
        Given I view New Arrivals section
        When it renders
        Then I should see 4 product cards in a grid
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        product_count = home_page.get_product_count()
        assert product_count == 4, f"Should display 4 products, got {product_count}"
    
    def test_view_all_products_button(self, driver, base_url):
        """
        Given I am in the New Arrivals section
        When I look for the View All button
        Then I should see "View All Products" button
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_new_arrivals()
        
        assert home_page.is_displayed(HomePage.VIEW_ALL_PRODUCTS_BUTTON), "View All Products button should be displayed"


@pytest.mark.homepage
class TestShopByCategorySection:
    """Test suite for Shop by Category Section (Story 4)."""
    
    def test_three_category_cards_displayed(self, driver, base_url):
        """
        Given I view the section
        When it renders
        Then I should see 3 category cards: Women's Collection, Men's Collection, Accessories
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        
        category_count = home_page.get_category_count()
        assert category_count == 3, f"Should display 3 categories, got {category_count}"
    
    def test_category_names_displayed(self, driver, base_url):
        """
        Given I view the Shop by Category section
        When I see the category cards
        Then I should see Women's, Men's, and Accessories categories
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_categories()
        
        assert home_page.is_displayed(HomePage.WOMENS_CATEGORY), "Women's Collection should be displayed"
        assert home_page.is_displayed(HomePage.MENS_CATEGORY), "Men's Collection should be displayed"
        assert home_page.is_displayed(HomePage.ACCESSORIES_CATEGORY), "Accessories should be displayed"


@pytest.mark.homepage
class TestAboutUsSection:
    """Test suite for About Us / Our Story Section (Story 5)."""
    
    def test_about_section_content(self, driver, base_url):
        """
        Given I view the section
        When it renders
        Then I should see "Our Story" label and "Crafted with Purpose" heading
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_about()
        
        assert home_page.is_displayed(HomePage.ABOUT_SECTION), "About section should be displayed"
        assert home_page.is_displayed(HomePage.ABOUT_HEADING), "Crafted with Purpose heading should be displayed"
    
    def test_learn_more_button(self, driver, base_url):
        """
        Given I view the section
        When it renders
        Then I should see a "Learn More About Us" button
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_about()
        
        assert home_page.is_displayed(HomePage.LEARN_MORE_BUTTON), "Learn More About Us button should be displayed"


@pytest.mark.homepage
class TestFeaturesSection:
    """Test suite for Features Section (Story 6)."""
    
    def test_three_feature_cards_displayed(self, driver, base_url):
        """
        Given I view feature cards
        When rendered
        Then I should see: Premium Quality, Secure Checkout, Free Shipping
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_features()
        
        assert home_page.is_displayed(HomePage.PREMIUM_QUALITY), "Premium Quality should be displayed"
        assert home_page.is_displayed(HomePage.SECURE_CHECKOUT), "Secure Checkout should be displayed"
        assert home_page.is_displayed(HomePage.FREE_SHIPPING), "Free Shipping should be displayed"


@pytest.mark.homepage
@pytest.mark.footer
class TestFooterWithNewsletter:
    """Test suite for Footer with Newsletter (Story 7)."""
    
    def test_footer_displayed(self, driver, base_url):
        """
        Given I am on any page
        When I scroll to footer
        Then I should see the footer with brand logo
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_footer()
        
        assert home_page.is_footer_displayed(), "Footer should be displayed"
        assert home_page.is_displayed(HomePage.FOOTER_LOGO), "Footer logo should be displayed"
    
    def test_social_links_displayed(self, driver, base_url):
        """
        Given I view the footer
        When rendered
        Then I should see social media links (Instagram, Facebook, Twitter)
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_footer()
        
        social_count = home_page.get_social_links_count()
        assert social_count == 3, f"Should have 3 social links, got {social_count}"
    
    def test_newsletter_section(self, driver, base_url):
        """
        Given I view newsletter section
        When rendered
        Then I should see email input and Subscribe button
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_footer()
        
        assert home_page.is_displayed(HomePage.NEWSLETTER_HEADING), "Newsletter heading should be displayed"
        assert home_page.is_displayed(HomePage.EMAIL_INPUT), "Email input should be displayed"
        assert home_page.is_displayed(HomePage.SUBSCRIBE_BUTTON), "Subscribe button should be displayed"
    
    def test_copyright_displayed(self, driver, base_url):
        """
        Given I view footer bottom
        When rendered
        Then I should see copyright text
        """
        home_page = HomePage(driver)
        home_page.navigate(base_url)
        home_page.scroll_to_footer()
        
        assert home_page.is_displayed(HomePage.COPYRIGHT), "Copyright text should be displayed"
# AI Generated Code by Deloitte + Cursor (END)
