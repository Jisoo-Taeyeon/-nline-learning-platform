package com.lagou.service.Impl;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 1:47
 */
@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;


    /**
     * 获取所有广告位
     *
     * @return
     */
    @Override
    public List<PromotionSpace> findAllPromotionSpace() {

        List<PromotionSpace> allPromotionSpace = promotionSpaceMapper.findAllPromotionSpace();

        return allPromotionSpace;
    }

    /**
     * 添加广告位
     *
     * @param promotionSpace
     */
    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {

        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);

        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    /**
     * 根据Id查询广告位信息
     *
     * @param id
     * @return
     */
    @Override
    public PromotionSpace findPromotionSpaceById(int id) {

        PromotionSpace promotionSpaceById = promotionSpaceMapper.findPromotionSpaceById(id);
        return promotionSpaceById;
    }

    /**
     * 更新广告位名称
     *
     * @param promotionSpace
     */
    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        // 封装数据
        promotionSpace.setUpdateTime(new Date());
        // 调用mapper
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);

    }
}
