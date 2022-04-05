package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

/**
 * @author 流年安好
 */
public interface PromotionAdService {

    /**
     * 分页查询广告信息
     * @param promotionAdVO
     * @return
     */
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    /**
     * 广告动态上下线
     * @param id
     * @param status
     */
    public void  updatePromotionAdStatus(int id,int status);

    /**
     * 新增广告信息
     * @param promotionAd
     */
    public void savePromotionAd(PromotionAd promotionAd);

    /**
     * 更新广告信息
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
