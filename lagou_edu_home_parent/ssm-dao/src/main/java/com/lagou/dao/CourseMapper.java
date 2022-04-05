package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

/**
 * @author 流年安好
 */
public interface CourseMapper {

    /**
     * 多条件课程列表查询
     * @param courseVO
     * @return
     */
    public List<Course> findAllCourseByCondition(CourseVO courseVO);

    /**
     * 新增课程信息
     * @param course
     */
    public void saveCourse(Course course);

    /**
     * 新增课程信息
     * @param teacher
     */
    public void saveTeacher(Teacher teacher);

    /**
     * 根据课程id 查询具体的课程信息及关联的讲师信息
     * 会显课程信息
     * @param id
     * @return
     */
    public CourseVO findCourseById(Integer id);

    /**
     * 更新课程信息
     * @param course
     */
    public void updateCourse(Course course);

    /**
     * 更新教师信息
     * @param teacher
     */
    public void updateTeacher(Teacher teacher);

    /**
     * 更新课程状态
     * @param course
     */
    public void updateCourseStatus(Course course);
}
