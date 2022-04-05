package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/3/31 9:59
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 课程多条件查询
     * @param courseVO
     * @return
     */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO) {
        List<Course> courseByCondition = courseService.findCourseByCondition(courseVO);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", courseByCondition);
        return responseResult;
    }

    /**
     * 课程图片上传
     * @return
     */
    @RequestMapping("/courseUpload")
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
        if (!filePath.getParentFile().exists()){
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
     * 新增课程信息和老师信息
     * 新增课程信息和修改课程信息要 写在一个方法中
     *
     * @param courseVO
     * @return
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        if (courseVO.getId() != null) {
            courseService.updateCourseOrTeacher(courseVO);
            ResponseResult responseResult = new ResponseResult(true, 200, "更新成功", null);
            return  responseResult;

        } else {
            courseService.saveCourseOrTeacher(courseVO);
            ResponseResult responseResult = new ResponseResult(true, 200, "新增成功", null);
            return  responseResult;
        }
    }

    /**
     * 根据id 查找课程信息 和教师信息
     * @param id
     * @return
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id) {
        CourseVO courseById = courseService.findCourseById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", courseById);
        return responseResult;

    }

    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id, Integer status) {
        // 调用service 传递参数
        courseService.updateCourseStatus(id, status);
        // 响应数据
        Map<String, Object> map = new HashMap<>();
        map.put("status",status);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功",map);
        return  responseResult;
    }

}
