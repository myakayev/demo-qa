package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class ConfigProvider {

    public static Properties properties = initProperties();
    private static Properties initProperties(){
        Properties prop = new Properties();
        try {
            prop.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("File config not found");
        }
        return prop;
    }

    public static WebDriver getDriver() {
        //int implicitlyWait = System.getenv("implicitly.wait");
        String driverName = Objects.isNull(System.getenv("browser")) ?    // перевіряємо, чи в енвайронменті записано змінну browser
                properties.getProperty("browser") : System.getenv("browser"); // якщо ні - йдемо в проперті, якщо так - беремо тут
        WebDriver driver =
            switch (driverName) {
                case "chrome":
                    yield new ChromeDriver(); // такий новий Switch-Case, який повертає значення, як ми можемо записати в змінну
                case "mozilla":
                    yield new FirefoxDriver();
                case "safari":
                    yield new SafariDriver();
                default: throw new RuntimeException("Unknown browser");
        };
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    public static String getBaseDomain() {
        return properties.getProperty("base.url");
    }
}
