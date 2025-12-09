# AI Generated Code by Deloitte + Cursor (BEGIN)
"""
Base Page Object class with common functionality.
"""
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains


class BasePage:
    """Base class for all Page Objects."""
    
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)
    
    def find_element(self, locator):
        """Find an element and wait for it to be present."""
        return self.wait.until(EC.presence_of_element_located(locator))
    
    def find_elements(self, locator):
        """Find multiple elements."""
        return self.driver.find_elements(*locator)
    
    def click(self, locator):
        """Wait for element to be clickable and click it."""
        element = self.wait.until(EC.element_to_be_clickable(locator))
        element.click()
        return self
    
    def type_text(self, locator, text):
        """Clear field and type text."""
        element = self.find_element(locator)
        element.clear()
        element.send_keys(text)
        return self
    
    def get_text(self, locator):
        """Get text from an element."""
        return self.find_element(locator).text
    
    def is_displayed(self, locator):
        """Check if element is displayed."""
        try:
            return self.find_element(locator).is_displayed()
        except:
            return False
    
    def scroll_to_element(self, locator):
        """Scroll to make element visible."""
        element = self.find_element(locator)
        self.driver.execute_script("arguments[0].scrollIntoView(true);", element)
        return self
    
    def hover_over(self, locator):
        """Hover over an element."""
        element = self.find_element(locator)
        ActionChains(self.driver).move_to_element(element).perform()
        return self
    
    def get_attribute(self, locator, attribute):
        """Get attribute value from an element."""
        return self.find_element(locator).get_attribute(attribute)
    
    def wait_for_element_visible(self, locator, timeout=10):
        """Wait for element to be visible."""
        wait = WebDriverWait(self.driver, timeout)
        return wait.until(EC.visibility_of_element_located(locator))
# AI Generated Code by Deloitte + Cursor (END)
