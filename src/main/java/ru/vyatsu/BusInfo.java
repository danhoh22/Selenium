package ru.vyatsu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BusInfo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://m.cdsvyatka.com/");

            // Выбор маршрута
            Select routeSelect = new Select(driver.findElement(By.xpath("//*[@id='MarshSelect']")));
            routeSelect.selectByIndex(4); // выбираем пятый маршрут

            // Подтверждение выбора
            WebElement confirmButton = driver.findElement(By.xpath("//*[@id='selMarsh']/input[1]"));
            confirmButton.click();
            Thread.sleep(1000); // Задержка в 1 секунду

            // Получение списка остановок
            List<String> stops = new ArrayList<>();
            for (int i = 2; i <= 5; i++) {
                // Находим элемент картинки
                WebElement image = driver.findElement(By.xpath("//*[@id='map']/div[1]/div[2]/div[3]/img[" + i + "]"));

                // Нажатие на картинку
                image.click();

                // Задержка для загрузки информации об остановке
                Thread.sleep(1000);

                WebElement stopInfo = driver.findElement(By.cssSelector("div.leaflet-popup-content > a"));
                stops.add(stopInfo.getText());
            }

            // Вывод списка остановок
            System.out.println("Список остановок: " + stops);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
