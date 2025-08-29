package seleniumTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectBoxExample {
    public static void main(String[] args) throws InterruptedException {
        // Setup driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open demo page
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // Initialize Select class
        Select select = new Select(dropdown);

        // Select by visible text
        select.selectByVisibleText("Option 1");
        System.out.println("✅ Selected Option 1");
        Thread.sleep(1000);

        // Select by value attribute
        select.selectByValue("2");
        System.out.println("✅ Selected Option 2");
        Thread.sleep(1000);

        // Select by index (0 = first option, 1 = second, etc.)
        select.selectByIndex(1); // selects Option 1
        System.out.println("✅ Selected Option by index");

        // Print selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Currently selected: " + selectedOption.getText());

        driver.quit();
    }
}
