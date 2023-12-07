package ru.vyatsu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DowloadPictures {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ru/images/search?from=tabbar&text=картинки%20шрека");

        try {
            // Ждем некоторое время для загрузки страницы
            Thread.sleep(5000);
            for (int i = 0; i < 6; i++) { // Прокручиваем страницу 5 раз, вы можете увеличить это число по необходимости
                scrollPage(driver);
                Thread.sleep(2000); // Ждем немного после каждой прокрутки
            }
            // Находим все элементы с картинками
            List<WebElement> images = driver.findElements(By.tagName("img"));
            String directory = System.getProperty("user.dir")+"\\src\\main\\resources\\picturesOfShrek";
            // Создаем папку, если её нет
            Files.createDirectories(Paths.get(directory));
            deleteFilesInDirectory(directory);

            // Счетчик для ограничения на 200 картинок
            int count = 0;
            // Сохраняем каждую картинку
            for (WebElement image : images) {
                String imageUrl = image.getAttribute("src");
                if (imageUrl != null && !imageUrl.isEmpty() && imageUrl.startsWith("http")) {
                    downloadImage(imageUrl, "src/main/resources/picturesOfShrek/image" + count + ".png");
                    count++;

                    if (count == 200) {
                        break;
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // Закрываем браузер после использования
            driver.quit();
        }
    }

    private static void downloadImage(String imageUrl, String destinationPath) {
        try {
            URL url = new URL(imageUrl);
            Files.copy(url.openStream(), new File(destinationPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void scrollPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    private static void deleteFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Проверяем, существует ли директория
        if (directory.exists() && directory.isDirectory()) {
            // Получаем список файлов в директории
            File[] files = directory.listFiles();

            // Проверяем, что список файлов не равен null
            if (files != null) {
                // Удаляем каждый файл
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.delete()) {
                            System.out.println("Файл удален: " + file.getName());
                        } else {
                            System.out.println("Не удалось удалить файл: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Указанный путь не является директорией или директория не существует.");
        }
    }
}
