package com.lagou.service;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author 流年安好
 */
public interface ResourceCategoryService {

    /**
     *  查询资源分类信息
     * @return
     */
    public List<ResourceCategory> findAllResourceCategory();
}
