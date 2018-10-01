package com.example.demo.service.util;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;


/**
 *
 * @author xxj
 * @version 创建时间：2017年4月27日 上午11:57:11
 */
public class FreemarkerHelper {


    /**
     * freemarker 通过模板生成内容(模板+数据模型=内容)
     * @param templateFile 模板文件地址
     * @param model 数据模型
     * @return
     *  @author xxj 2017年4月27日
     */
    public static String getContent(String templateFile,HashMap<String, Object> model) {
        try {
            System.out.println("freemarker 读取模板："+templateFile);
            File file = new File(templateFile);
            if(!file.exists()){
                throw new Exception("模板文件不存在："+templateFile);
            }

            String templateDir = file.getParentFile().getPath();
            String templateName =file.getName();
            System.out.println("模板目录："+templateDir);
            System.out.println("模板名称："+templateName);
            //1 配置 freemarker
            Configuration cfg= new Configuration(Configuration.VERSION_2_3_25);
            cfg.setDirectoryForTemplateLoading(new File(templateDir));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setOutputEncoding("UTF-8");
            cfg.setLogTemplateExceptions(false);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            //2 生成内容
//			Writer out = new OutputStreamWriter(System.out); //输出内容到控制台
            //输出内容到字符串流
            StringWriter out = new StringWriter();
            Template temp = cfg.getTemplate(templateName);
            temp.process(model, out);
            out.flush();
            return out.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }
}

