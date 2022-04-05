package com.lagou.service.Impl;

import com.lagou.dao.TestMapper;
import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/3/30 23:26
 */
@Service
public class TestServiceImp implements TestService {
    @Autowired
    private TestMapper testMapper;
    /**
     * 测试查询所有
     *
     * @return
     */
    @Override
    public List<Test> findAll() {
        return testMapper.findAll();
    }
}
