package com.lagou.controller;

import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/3/30 23:35
 */
@RestController // 组合了@Controller +@ResponseBody
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/findAll")
    public List<Test> findAll(){
        List<Test> all = testService.findAll();
        return all;
    }
}
