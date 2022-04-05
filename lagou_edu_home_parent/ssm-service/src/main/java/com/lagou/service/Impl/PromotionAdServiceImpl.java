package com.lagou.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 1:44
 */
@Service
public class PromotionAdServiceImpl implements PromotionAdService {
    @Autowired
    private PromotionAdMapper promotionAdMapper;


    /**
     * 分页查询广告信息
     *
     * @param promotionAdVO
     * @return
     */
    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {

        PageHelper.startPage(promotionAdVO.getCurrentPage(), promotionAdVO.getPageSize());
        List<PromotionAd> allPromotionAdByPage = promotionAdMapper.findAllPromotionAdByPage();
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionAdByPage);
        return pageInfo;
    }

    /**
     * 广告动态上下线
     *
     * @param id
     * @param status
     */
    @Override
    public void updatePromotionAdStatus(int id, int status) {
        // 封装数据
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());
        // 调用mapper
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }

    /**
     * 新增广告信息
     *
     * @param promotionAd
     */
    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        promotionAdMapper.savePromotionAd(promotionAd);

    }

    /**
     * 更新广告信息
     *
     * @param promotionAd
     */
    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    /**
     * 根据id 查找广告信息
     * 回显广告信息
     *
     * @param id
     * @return
     */
    @Override
    public PromotionAd findPromotionAdById(Integer id) {
        return promotionAdMapper.findPromotionAdById(id);
    }
}
