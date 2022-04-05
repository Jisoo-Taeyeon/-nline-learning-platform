package com.lagou.dao;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @author 流年安好
 */
public interface TestMapper {
    /**
     * 测试查询所有
     * @return
     */
    public List<Test> findAll();
}
