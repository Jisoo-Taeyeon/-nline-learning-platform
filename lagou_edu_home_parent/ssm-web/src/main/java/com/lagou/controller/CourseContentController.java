package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/3/31 23:57
 */
@RestController
@RequestMapping("/courseContent")
public class CourseContentController {
    @Autowired
    private CourseContentService courseContentService;

    /**
     * 根据课程id 查找课程内容信息 章节信息 和课时内容信息
     * @param courseId
     * @return
     */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(Integer courseId){
        System.out.println("***********************************");
        System.out.println("根据课程id 查找课程内容信息 章节信息 和课时内容信息");
        System.out.println("***********************************");


        // 调用service
        List<CourseSection> list = courseContentService.findSectionAndLessonByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult(true, 200, "章节及课时内容查询成功", list);

        return responseResult;
    }


    /**
     * 回显章节对应的课程信息
     * @param courseId
     * @return
     */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId){

        Course course = courseContentService.findCourseByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询课程信息成功", course);

        return  responseResult;

    }


    /**
     * 新增&更新章节信息
     * @param courseSection
     * @return
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){

        // 判断是否携带了章节ID
        if(courseSection.getId() == null){
            // 新增
            courseContentService.saveSection(courseSection);
            return  new ResponseResult(true,200,"新增章节成功",null);
        }else {
            // 更新
            courseContentService.updateSection(courseSection);
            return  new ResponseResult(true,200,"更新章节成功",null);
        }

    }

    /**
     * 修改章节状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(int id,int status){

        courseContentService.updateSectionStatus(id,status);

        //数据响应
        Map<Object, Object> map = new HashMap<>();
        map.put("status",status);

        ResponseResult responseResult = new ResponseResult(true, 200, "修改章节状态成功", map);
        return responseResult;

    }

}
