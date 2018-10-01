
package com.example.demo.service.util;


import java.util.HashMap;


/**
 * @author xxj
 * @version 创建时间：2017年4月27日 下午1:26:24
 */
public class PdfCreator {
    /**
     * 通过 freemarker 生成pdf
     *
     * @param templateFile 模板文件地址
     * @param model        数据模型
     * @param pdfPath      生成pdf路径
     * @return
     * @author xxj 2017年4月27日
     */
    public static boolean CreateByFreemarker(String templateFile
            , HashMap<String, Object> model
            , String pdfPath) {
        //生成 内容
        String xhtml = FreemarkerHelper.getContent(templateFile, model);
        if (xhtml == null || xhtml.isEmpty()) {
            System.out.println("xhtml 内容为空，生成失败！");
            return false;
        }

        //生成pdf
        return PdfHelper.craetePdfByXhtml(xhtml, pdfPath, templateFile);
    }
}
