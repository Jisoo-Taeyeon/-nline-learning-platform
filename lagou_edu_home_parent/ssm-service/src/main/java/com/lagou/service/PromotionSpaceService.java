package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @author 流年安好
 */
public interface PromotionSpaceService {


    /**
     * 获取所有广告位
     * @return
     */
    public List<PromotionSpace> findAllPromotionSpace();


    /**
     * 添加广告位
     * @param promotionSpace
     */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 根据Id查询广告位信息
     * @param id
     * @return
     */
    public PromotionSpace findPromotionSpaceById(int id);

    /**
     * 更新广告位名称
     * @param promotionSpace
     */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
