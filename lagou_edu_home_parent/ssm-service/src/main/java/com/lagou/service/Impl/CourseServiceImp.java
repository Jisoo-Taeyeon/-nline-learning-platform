package com.lagou.service.Impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/3/31 9:55
 */
@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    /**
     * 多条件查询课程列表
     *
     * @param courseVO
     * @return
     */
    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {

        List<Course> allCourseByCondition = courseMapper.findAllCourseByCondition(courseVO);
        return allCourseByCondition;
    }

    /**
     * 添加课程信息和老师
     *
     * @param courseVO
     */
    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        // 封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);
        //补全课程信息
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        //保存课程 自动插入id值 并会把id值赋给course对象
        courseMapper.saveCourse(course);
        System.out.println("*****"+course);

        // 获取新插入的数据的id值
        int id = course.getId();

        // 封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);
        System.out.println("*****"+teacher);


        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);
        teacher.setCourseId(id);

        // 保存讲师信息
        courseMapper.saveTeacher(teacher);

    }

    /**
     * 根据课程id 查找课程信息 和教师信息
     *
     * @param id
     * @return
     */
    @Override
    public CourseVO findCourseById(Integer id) {

        return courseMapper.findCourseById(id);
    }

    /**
     * 更新课程信息和教师信息
     *
     * @param courseVO
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVO);
        Date date = new Date();
        course.setUpdateTime(date);
        //保存课程信息
        courseMapper.updateCourse(course);

        // 封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);

        // 补全信息
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        // 更新讲师信息
        courseMapper.updateTeacher(teacher);

    }

    /**
     * 更新课程状态
     * @param courseId
     * @param status
     */
    @Override
    public void updateCourseStatus(int courseId,int status) {
        Course course = new Course();
        course.setId(courseId);
        course.setStatus(status);
        course.setUpdateTime(new Date());
        courseMapper.updateCourseStatus(course);

    }

}
