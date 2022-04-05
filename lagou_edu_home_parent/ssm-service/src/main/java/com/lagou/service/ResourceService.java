package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourseVo;

import java.util.List;

/**
 * @author 流年安好
 */
public interface ResourceService {

    /**
     * 资源分页多条件查询
     * @param resourseVo
     * @return
     */
    public PageInfo<Resource> findAllResourceByPag(ResourseVo resourseVo);
}
