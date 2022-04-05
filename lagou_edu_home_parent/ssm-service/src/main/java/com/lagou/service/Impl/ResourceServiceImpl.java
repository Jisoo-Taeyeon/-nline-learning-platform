package com.lagou.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourseVo;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/2 15:41
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 资源分页多条件查询
     *
     * @param resourseVo
     * @return
     */
    @Override
    public PageInfo<Resource> findAllResourceByPag(ResourseVo resourseVo) {
        // 分页查询
        PageHelper.startPage(resourseVo.getCurrentPage(), resourseVo.getPageSize());
        List<Resource> allResourceByPage = resourceMapper.findAllResourceByPage(resourseVo);

        PageInfo<Resource> pageInfo = new PageInfo<>(allResourceByPage);
        return pageInfo;
    }
}
