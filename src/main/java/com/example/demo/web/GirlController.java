package com.example.demo.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //   WebDriverManager.phantomjs().setup();
        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", true);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //驱动支持
        String osName = System.getProperties().getProperty("os.name").toLowerCase();
        System.out.println(osName);
        if (osName.indexOf("linux")>-1) {
            dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/home/deploy/driver/phantomjs");
        }else{
            dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\code\\environment\\phantomJS\\phantomjs.exe");
        }
        Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
        String[] phantomArgs = new  String[] {
                "--webdriver-logfile=/home/deploy/phantomjsdriver.log"//,
               // "--webdriver-loglevel=NONE"
        };
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
        PhantomJSDriver driver = new PhantomJSDriver(dcaps);
   //     driver.setLogLevel(Level.OFF);
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
