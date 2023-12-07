package ru.vyatsu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Otzyv {
    public static void main(String[] args) {
        WebDriver otzyv = new ChromeDriver();
        try {
            otzyv.get("https://otzyv.ru/");
            WebElement confirmButton=otzyv.findElement(By.xpath("//td[@class='item']/a[text()='Форумы']"));
            confirmButton.click();
            Thread.sleep(2000); // Задержка в 1 секунду
            WebElement search=otzyv.findElement(By.xpath("//input[@name='s']"));
            search.sendKeys("Россия");
            Select category = new Select(otzyv.findElement(By.xpath("//*[@name='f']")));
            category.selectByIndex(14);
            WebElement checkbox = otzyv.findElement(By.name("onlytheme"));
            checkbox.click();
            WebElement selectButton=otzyv.findElement(By.cssSelector(".submit input[type='submit']"));
            selectButton.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
    }
    }
}
