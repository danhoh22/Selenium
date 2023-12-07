package ru.vyatsu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Otzovik {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://otzovik.com/");
            WebElement forumButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/a[2]"));
            forumButton.click();

            WebElement product = driver.findElement(By.xpath("//*[@id=\"tproduct\"]"));
            product.sendKeys("Мультфильм \"Шрек\" (2001)");
            Thread.sleep(2000);

            WebElement writeButton = driver.findElement(By.xpath("//*[@id=\"noproduct\"]"));
            writeButton.click();
            Thread.sleep(2000);

            Select ratingSelect = new Select(driver.findElement(By.xpath("//*[@id=\"rating0\"]")));
            ratingSelect.selectByIndex(5);

            WebElement generalImpressions = driver.findElement(By.xpath("//*[@id=\"content_title\"]"));
            generalImpressions.sendKeys("Классный фильм!");
            Thread.sleep(2000);

            WebElement impressions = driver.findElement(By.xpath("//*[@id=\"content_body_main\"]/div[2]/div[2]/div/textarea[2]"));
            impressions.sendKeys("Просто ухохатбл, батю порвало, меня тоже, мама в шоке.");
            Thread.sleep(2000);

            WebElement pluses = driver.findElement(By.xpath("//*[@id=\"review_post\"]/div[4]/div[2]/textarea"));
            pluses.sendKeys("Опупенный фильм");

            WebElement minuses = driver.findElement(By.xpath("//*[@id=\"review_post\"]/div[5]/div[2]/textarea"));
            minuses.sendKeys("Он прекрасен");

            WebElement recomend = driver.findElement(By.xpath("//*[@id=\"review_post\"]/div[6]/div[1]/div[2]/label[1]/span"));
            recomend.click();

            WebElement purchaseMethod = driver.findElement(By.xpath("//*[@id=\"wayofac\"]/div[2]/div[2]/label/span[1]"));
            purchaseMethod.click();

            WebElement yearOfPurchase = driver.findElement(By.xpath("//*[@id=\"slval1351\"]"));
            yearOfPurchase.sendKeys("2024");

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
