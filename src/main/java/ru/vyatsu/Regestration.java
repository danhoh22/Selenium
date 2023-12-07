package ru.vyatsu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Regestration {
    public static void main(String[] args) {
        WebDriver otzyv = new ChromeDriver();
        try {
            otzyv.get("https://irecommend.ru/");
            WebElement selectButton = otzyv.findElement(By.xpath("/html/body/div[1]/header/div[1]/a"));
            selectButton.click();
            WebElement regButton=otzyv.findElement(By.xpath("//*[@id=\"user-login\"]/div/div/div[6]/div[2]/a"));
            regButton.click();
            WebElement name=otzyv.findElement(By.xpath("//*[@id=\"edit-name\"]"));
            name.sendKeys("danhoh22");
            WebElement email=otzyv.findElement(By.xpath("//*[@id=\"edit-mail\"]"));
            email.sendKeys("danhoh22@gmail.com");
            WebElement password=otzyv.findElement(By.xpath("//*[@id=\"edit-pass-pass1\"]"));
            password.sendKeys("12345678");
            WebElement passwordAgain=otzyv.findElement(By.xpath("//*[@id=\"edit-pass-pass2\"]"));
            passwordAgain.sendKeys("12345678");
            WebElement checkBox=otzyv.findElement(By.xpath("//*[@id=\"edit-reg-policy-wrapper\"]/div"));
            checkBox.sendKeys();
            Thread.sleep(2000); // Задержка в 1 секунду
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
