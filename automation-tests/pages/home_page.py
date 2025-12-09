# AI Generated Code by Deloitte + Cursor (BEGIN)
"""
Home Page Object Model for Crest & Thread e-commerce site.
"""
from selenium.webdriver.common.by import By
from pages.base_page import BasePage


class HomePage(BasePage):
    """Page Object for the Home Page."""
    
    # Header Locators
    LOGO = (By.XPATH, "//a[contains(@href, '/')]//span[contains(text(), 'Crest & Thread')]")
    NAV_NEW_ARRIVALS = (By.XPATH, "//a[contains(@href, '/new-arrivals')]")
    NAV_MEN = (By.XPATH, "//a[contains(@href, '/men')]")
    NAV_WOMEN = (By.XPATH, "//a[contains(@href, '/women')]")
    NAV_COLLECTIONS = (By.XPATH, "//a[contains(@href, '/collections')]")
    NAV_SALE = (By.XPATH, "//a[contains(@href, '/sale')]")
    SEARCH_BUTTON = (By.XPATH, "//button[@aria-label='Search']")
    ACCOUNT_BUTTON = (By.XPATH, "//button[@aria-label='Account']")
    CART_BUTTON = (By.XPATH, "//button[@aria-label='Cart']")
    CART_COUNT = (By.XPATH, "//button[@aria-label='Cart']//span")
    MENU_BUTTON = (By.XPATH, "//button[@aria-label='Menu']")
    
    # Hero Section Locators
    HERO_SECTION = (By.CSS_SELECTOR, "section.relative")
    HERO_LABEL = (By.XPATH, "//*[contains(text(), 'Winter Collection 2025')]")
    HERO_HEADING = (By.TAG_NAME, "h1")
    HERO_DESCRIPTION = (By.XPATH, "//*[contains(text(), 'Discover our curated collection')]")
    SHOP_NOW_BUTTON = (By.XPATH, "//button[contains(text(), 'Shop Now')]")
    EXPLORE_COLLECTIONS_BUTTON = (By.XPATH, "//button[contains(text(), 'Explore Collections')]")
    HERO_IMAGE = (By.XPATH, "//img[@alt='Fashion collection showcase']")
    
    # New Arrivals Section Locators
    NEW_ARRIVALS_SECTION = (By.XPATH, "//h2[contains(text(), 'New Arrivals')]/ancestor::section")
    NEW_ARRIVALS_LABEL = (By.XPATH, "//*[contains(text(), 'Curated Selection')]")
    NEW_ARRIVALS_HEADING = (By.XPATH, "//h2[contains(text(), 'New Arrivals')]")
    PRODUCT_CARDS = (By.CSS_SELECTOR, "article.group")
    VIEW_ALL_PRODUCTS_BUTTON = (By.XPATH, "//button[contains(text(), 'View All Products')]")
    
    # Shop by Category Section Locators
    CATEGORY_SECTION = (By.XPATH, "//h2[contains(text(), 'Shop by Category')]/ancestor::section")
    CATEGORY_CARDS = (By.XPATH, "//a[contains(@href, '/category/')]")
    WOMENS_CATEGORY = (By.XPATH, "//h3[contains(text(), \"Women's Collection\")]")
    MENS_CATEGORY = (By.XPATH, "//h3[contains(text(), \"Men's Collection\")]")
    ACCESSORIES_CATEGORY = (By.XPATH, "//h3[contains(text(), 'Accessories')]")
    
    # About Us Section Locators
    ABOUT_SECTION = (By.XPATH, "//*[contains(text(), 'Our Story')]/ancestor::section")
    ABOUT_HEADING = (By.XPATH, "//h2[contains(text(), 'Crafted with Purpose')]")
    LEARN_MORE_BUTTON = (By.XPATH, "//button[contains(text(), 'Learn More About Us')]")
    
    # Features Section Locators
    FEATURES_SECTION = (By.XPATH, "//h3[contains(text(), 'Premium Quality')]/ancestor::section")
    PREMIUM_QUALITY = (By.XPATH, "//h3[contains(text(), 'Premium Quality')]")
    SECURE_CHECKOUT = (By.XPATH, "//h3[contains(text(), 'Secure Checkout')]")
    FREE_SHIPPING = (By.XPATH, "//h3[contains(text(), 'Free Shipping')]")
    
    # Footer Locators
    FOOTER = (By.TAG_NAME, "footer")
    FOOTER_LOGO = (By.XPATH, "//footer//span[contains(text(), 'Crest & Thread')]")
    NEWSLETTER_HEADING = (By.XPATH, "//h3[contains(text(), 'Join Our Newsletter')]")
    EMAIL_INPUT = (By.XPATH, "//input[@placeholder='Enter your email']")
    SUBSCRIBE_BUTTON = (By.XPATH, "//button[contains(text(), 'Subscribe')]")
    INSTAGRAM_LINK = (By.XPATH, "//a[@aria-label='instagram']")
    FACEBOOK_LINK = (By.XPATH, "//a[@aria-label='facebook']")
    TWITTER_LINK = (By.XPATH, "//a[@aria-label='twitter']")
    COPYRIGHT = (By.XPATH, "//*[contains(text(), '© 2025 Crest & Thread')]")
    
    def __init__(self, driver):
        super().__init__(driver)
    
    def navigate(self, base_url):
        """Navigate to the home page."""
        self.driver.get(base_url)
        return self
    
    # Header Actions
    def is_logo_displayed(self):
        """Check if logo is displayed."""
        return self.is_displayed(self.LOGO)
    
    def click_new_arrivals_nav(self):
        """Click on New Arrivals navigation link."""
        self.click(self.NAV_NEW_ARRIVALS)
        return self
    
    def click_search(self):
        """Click on search button."""
        self.click(self.SEARCH_BUTTON)
        return self
    
    def click_cart(self):
        """Click on cart button."""
        self.click(self.CART_BUTTON)
        return self
    
    def get_cart_count(self):
        """Get the cart item count."""
        return self.get_text(self.CART_COUNT)
    
    def get_nav_links_count(self):
        """Get count of navigation links."""
        links = self.find_elements((By.CSS_SELECTOR, "nav ul li a"))
        return len(links)
    
    # Hero Section Actions
    def is_hero_displayed(self):
        """Check if hero section is displayed."""
        return self.is_displayed(self.HERO_SECTION)
    
    def get_hero_heading_text(self):
        """Get hero heading text."""
        return self.get_text(self.HERO_HEADING)
    
    def click_shop_now(self):
        """Click Shop Now button."""
        self.click(self.SHOP_NOW_BUTTON)
        return self
    
    def click_explore_collections(self):
        """Click Explore Collections button."""
        self.click(self.EXPLORE_COLLECTIONS_BUTTON)
        return self
    
    def is_hero_image_displayed(self):
        """Check if hero image is displayed."""
        return self.is_displayed(self.HERO_IMAGE)
    
    # New Arrivals Actions
    def scroll_to_new_arrivals(self):
        """Scroll to New Arrivals section."""
        self.scroll_to_element(self.NEW_ARRIVALS_SECTION)
        return self
    
    def get_product_count(self):
        """Get count of product cards."""
        self.scroll_to_new_arrivals()
        return len(self.find_elements(self.PRODUCT_CARDS))
    
    def hover_over_product(self, index=0):
        """Hover over a product card."""
        products = self.find_elements(self.PRODUCT_CARDS)
        if index < len(products):
            from selenium.webdriver.common.action_chains import ActionChains
            ActionChains(self.driver).move_to_element(products[index]).perform()
        return self
    
    def click_view_all_products(self):
        """Click View All Products button."""
        self.scroll_to_new_arrivals()
        self.click(self.VIEW_ALL_PRODUCTS_BUTTON)
        return self
    
    # Category Section Actions
    def scroll_to_categories(self):
        """Scroll to Shop by Category section."""
        self.scroll_to_element(self.CATEGORY_SECTION)
        return self
    
    def get_category_count(self):
        """Get count of category cards."""
        self.scroll_to_categories()
        return len(self.find_elements(self.CATEGORY_CARDS))
    
    # About Section Actions
    def scroll_to_about(self):
        """Scroll to About Us section."""
        self.scroll_to_element(self.ABOUT_SECTION)
        return self
    
    def click_learn_more(self):
        """Click Learn More About Us button."""
        self.scroll_to_about()
        self.click(self.LEARN_MORE_BUTTON)
        return self
    
    # Features Section Actions
    def scroll_to_features(self):
        """Scroll to Features section."""
        self.scroll_to_element(self.FEATURES_SECTION)
        return self
    
    def is_premium_quality_displayed(self):
        """Check if Premium Quality feature is displayed."""
        self.scroll_to_features()
        return self.is_displayed(self.PREMIUM_QUALITY)
    
    # Footer Actions
    def scroll_to_footer(self):
        """Scroll to footer."""
        self.scroll_to_element(self.FOOTER)
        return self
    
    def subscribe_to_newsletter(self, email):
        """Subscribe to newsletter."""
        self.scroll_to_footer()
        self.type_text(self.EMAIL_INPUT, email)
        self.click(self.SUBSCRIBE_BUTTON)
        return self
    
    def is_footer_displayed(self):
        """Check if footer is displayed."""
        return self.is_displayed(self.FOOTER)
    
    def get_social_links_count(self):
        """Get count of social media links."""
        instagram = 1 if self.is_displayed(self.INSTAGRAM_LINK) else 0
        facebook = 1 if self.is_displayed(self.FACEBOOK_LINK) else 0
        twitter = 1 if self.is_displayed(self.TWITTER_LINK) else 0
        return instagram + facebook + twitter
# AI Generated Code by Deloitte + Cursor (END)
