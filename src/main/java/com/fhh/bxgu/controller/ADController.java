package com.fhh.bxgu.controller;

import com.alibaba.fastjson.JSON;
import com.fhh.bxgu.service.ADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ADController {
    @Autowired
    private ADService adService;
    @RequestMapping(value = "get_ad_list",produces = "application/json;charset=UTF-8")
    public String getAdList() {
        //直接返回由数据库查询返回的字符串。
        List<String> uuid = adService.getADList();
        return JSON.toJSONString(uuid);
    }
}
