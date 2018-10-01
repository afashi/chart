package com.example.demo.service;

import com.example.demo.service.util.PdfCreator;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.Date;
import java.util.HashMap;

public class pdfServiceImpl {
    public static void outputPdf() throws Exception {


            String rootPath = "src/main/resources/";

            String fileName = "template/pdf/pdf-ferrmarker.pdf";

            String pdf = rootPath+fileName;

            String template = rootPath+"template/about.ftl";

            HashMap<String, Object> pars = new HashMap<String, Object>();
            pars.put("name", "张三111123");
            pars.put("age", 30);
            pars.put("time", new Date());

            boolean success = PdfCreator.CreateByFreemarker(template, pars, pdf);




    }
    public static void main(String[] arg){
        try {
            outputPdf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
