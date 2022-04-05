package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourseVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/2 15:45
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourseVo resourseVo) {
        PageInfo<Resource> allResourceByPag = resourceService.findAllResourceByPag(resourseVo);

        ResponseResult responseResult = new ResponseResult(true, 200, "资源信息分页&条件查询", allResourceByPag);
        return responseResult;
    }
}
