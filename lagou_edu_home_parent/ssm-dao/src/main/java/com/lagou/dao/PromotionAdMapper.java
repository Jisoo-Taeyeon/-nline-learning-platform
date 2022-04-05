package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**
 * @author 流年安好
 */
public interface PromotionAdMapper {
    /**
     * 分页查询广告信息
     * @return
     */
    public List<PromotionAd> findAllPromotionAdByPage();

    /**
     * 广告的动态上下线
     * @param promotionAd
     */
    public void updatePromotionAdStatus(PromotionAd promotionAd);

    /**
     * 新增广告位
     * @param promotionAd
     */
    public void savePromotionAd(PromotionAd promotionAd);

    /**
     * 更新广告位
     * @param promotionAd
     */
    public void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 根据id 查找广告信息
     * 回显广告信息
     * @param id
     * @return
     */
    public PromotionAd findPromotionAdById(Integer id);
}
