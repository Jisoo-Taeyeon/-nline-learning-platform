package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourseVo;

import java.util.List;

/**
 * @author 流年安好
 */
public interface ResourceMapper {

    /**
     *  资源分页&多条件查询
     * @param resourseVo
     * @return
     */
    public List<Resource> findAllResourceByPage(ResourseVo resourseVo);
}
