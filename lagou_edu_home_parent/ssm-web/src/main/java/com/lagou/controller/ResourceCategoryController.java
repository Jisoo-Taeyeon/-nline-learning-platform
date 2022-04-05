package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/2 15:09
 */
@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {
    @Autowired
    private ResourceCategoryService resourceCategoryService;
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult  findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();
        ResponseResult responseResult = new ResponseResult(true, 200, "查询资源分类信息成功", allResourceCategory);
        return  responseResult;
    }

}
