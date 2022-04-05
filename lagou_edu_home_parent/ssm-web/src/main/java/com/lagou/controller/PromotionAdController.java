package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 2:40
 */
@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {
    @Autowired
    private PromotionAdService promotionAdService;

    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllAdByPage(PromotionAdVO promotionAdVO) {
        System.out.println("****************************");
        System.out.println(promotionAdVO);
        PageInfo<PromotionAd> allPromotionAdByPage = promotionAdService.findAllPromotionAdByPage(promotionAdVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", allPromotionAdByPage);

        return responseResult;

    }

    /**
     * 课程图片上传
     *
     * @return
     */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //1.判断接受到的上传文件是否为空
        if (file.isEmpty()) {
            throw new RuntimeException();
        }
        //2.获取项目部署路径  F:\tomcat\apache-tomcat-9.0.13\webapps\ssm-web\
        String realPath = request.getServletContext().getRealPath("/");
        //2.1 进行截取 F:\tomcat\apache-tomcat-9.0.13\webapps\
        String webappsPath = realPath.substring(0, realPath.indexOf("ssm-web"));
        //3.获取原文件名  Irene.jpg
        String oldFileName = file.getOriginalFilename();
        //4. 生成新的文件名   20221211.jpg
        String newFileName = System.currentTimeMillis() + oldFileName.substring(oldFileName.lastIndexOf("."));

        //5. 文件上传
        String uploadPath = webappsPath + "upload\\";
        File filePath = new File(uploadPath, newFileName);

        // 如果目录不存在要创造目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录");
        }
        //图片进行真正的上传
        file.transferTo(filePath);

        //6. 将文件名和文件路径返回进行响应
        HashMap<String, String> map = new HashMap<>();

        map.put("fileName", newFileName);
        map.put("filePath", "http://localhost:8080/upload/" + newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);

        return responseResult;
    }

    /**
     * 广告动态上下线
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionStatus(Integer id, Integer status) {

        promotionAdService.updatePromotionAdStatus(id, status);

        ResponseResult responseResult = new ResponseResult(true, 200, "广告动态上下线成功", null);

        return responseResult;

    }

    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(PromotionAd promotionAd) {
        if (promotionAd.getId() == null) {
            Date date = new Date();
            promotionAd.setUpdateTime(date);
            promotionAd.setCreateTime(date);
            promotionAdService.savePromotionAd(promotionAd);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", null);
            return result;
        } else {
            Date date = new Date();
            promotionAd.setUpdateTime(date);
            promotionAdService.updatePromotionAd(promotionAd);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", null);
            return result;
        }
    }

    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(Integer id) {
        PromotionAd promotionAdById = promotionAdService.findPromotionAdById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "回显相应成功", promotionAdById);
        return responseResult;
    }
}
