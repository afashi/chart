package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库操作
 * Created by afas on 2017/3/29.
 */
@RestController
public class GirlController {
    /**
     * 查询列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    @ResponseBody
    public String girlList() {
        return "hello world";
    }


}
