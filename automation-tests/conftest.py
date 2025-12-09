# AI Generated Code by Deloitte + Cursor (BEGIN)
"""
Pytest configuration and fixtures for E2E tests.
"""
import os
import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from dotenv import load_dotenv

# Load environment variables
load_dotenv()


@pytest.fixture(scope="session")
def base_url():
    """Get the base URL from environment or default to localhost."""
    return os.getenv("TEST_BASE_URL", "http://localhost:5173")


@pytest.fixture(scope="function")
def driver(request):
    """Create and return a WebDriver instance."""
    headless = os.getenv("HEADLESS", "true").lower() == "true"
    browser = os.getenv("SELENIUM_BROWSER", "chrome")
    
    if browser == "chrome":
        options = Options()
        if headless:
            options.add_argument("--headless")
        options.add_argument("--no-sandbox")
        options.add_argument("--disable-dev-shm-usage")
        options.add_argument("--window-size=1920,1080")
        
        service = Service(ChromeDriverManager().install())
        driver = webdriver.Chrome(service=service, options=options)
    else:
        raise ValueError(f"Unsupported browser: {browser}")
    
    driver.implicitly_wait(10)
    
    yield driver
    
    driver.quit()


@pytest.fixture(scope="function")
def navigate_to_home(driver, base_url):
    """Navigate to home page before test."""
    driver.get(base_url)
    return driver
# AI Generated Code by Deloitte + Cursor (END)
