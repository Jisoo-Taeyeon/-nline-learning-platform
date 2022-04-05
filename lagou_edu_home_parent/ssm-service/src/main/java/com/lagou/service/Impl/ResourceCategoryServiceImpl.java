package com.lagou.service.Impl;

import com.lagou.dao.ResourceCategoryMapper;
import com.lagou.domain.ResourceCategory;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/2 15:12
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;
    /**
     * 查询资源分类信息
     *
     * @return
     */
    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }
}
