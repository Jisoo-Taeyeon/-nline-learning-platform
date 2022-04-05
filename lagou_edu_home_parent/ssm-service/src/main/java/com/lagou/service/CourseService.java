package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author 流年安好
 */
public interface CourseService {
    /**
     * 多条件查询课程列表
     * @param courseVO
     * @return
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /**
     * 添加课程信息和老师
     * @param courseVO
     */
    public void  saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /**
     * 根据课程id 查找课程信息 和教师信息
     * @param id
     * @return
     */
    public CourseVO findCourseById(Integer id);


    /**
     * 更新课程信息和教师信息
     * @param courseVO
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void  updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /**
     * 更新课程状态
     * @param courseId
     * @param status
     */
    public void updateCourseStatus(int courseId,int status);
}
