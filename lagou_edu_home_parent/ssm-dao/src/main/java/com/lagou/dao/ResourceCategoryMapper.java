package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author 流年安好
 */
public interface ResourceCategoryMapper {

    /**
     * 查询所有资源分类
     * @return
     */
    public List<ResourceCategory> findAllResourceCategory();



}
