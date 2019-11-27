import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumUsage {
    public static void main(String[] args) throws InterruptedException {

        String url = "https://www.kinomania.ru/genres/films";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1500);
            String s = driver.getPageSource();
            Document doc = Jsoup.parse(s);
            Elements elements = doc.getElementsByAttributeValue("class", "table-top-title");
            for (Element e : elements) {
                String s1 = e.getElementsByAttribute("href").get(0).
                        attr("href").replaceAll("\\D+", "");
                System.out.println(s1);
            }
            driver.findElement(By.linkText(">")).click();
        }
        driver.close();
        System.exit(0);
    }
}
