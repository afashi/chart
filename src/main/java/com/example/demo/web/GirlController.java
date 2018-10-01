package com.example.demo.web;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 数据库操作
 * Created by afas on 2017/3/29.
 */
@Controller
public class GirlController {
    /**
     * 查询列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public void girlList(HttpServletResponse res) throws IOException {
/*        WebClient webClient = new WebClient();

        HtmlPage page = webClient.getPage("http://localhost:8080/h");
        webClient.waitForBackgroundJavaScript(2000);
        String svg = page.getElementById("pic").asXml();
        String src = page.getElementById("pic").getAttribute("src");
        src = src.replace("data:image/png;base64,", "");
        OutputStream os = res.getOutputStream();
        byte[] b = new BASE64Decoder().decodeBuffer(src);
        os.write(b);
        os.flush();
        os.close();*/
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.setProperty("webdriver.chrome.driver", path + "\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        设置为 headless 模式 （必须）
        chromeOptions.addArguments("--headless");
//        设置浏览器窗口打开大小  （非必须）
        chromeOptions.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://localhost:8080/h");
        String src = driver.findElement(By.id("pic")).getAttribute("src");
        src = src.replace("data:image/png;base64,", "");
        OutputStream os = res.getOutputStream();
        byte[] b = new BASE64Decoder().decodeBuffer(src);
        driver.quit();
        os.write(b);
        os.flush();
        os.close();

    }

    @GetMapping(value = "/h")
    public String a() {
        return "chart";
    }
}
