package com.lagou.service.Impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/3/31 23:47
 */
@Service
public class CourseContentServiceImp implements CourseContentService {
    @Autowired
    private CourseContentMapper courseContentMapper;
    /**
     * 根据课程ID查询对应的课程内容（章节+课时）
     *
     * @param courseId
     * @return
     */
    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        List<CourseSection> sectionAndLessonByCourseId = courseContentMapper.findSectionAndLessonByCourseId(courseId);
        return sectionAndLessonByCourseId;
    }

    /**
     * 回显章节对应的课程信息
     *
     * @param courseId
     * @return
     */
    @Override
    public Course findCourseByCourseId(int courseId) {
        Course courseByCourseId = courseContentMapper.findCourseByCourseId(courseId);
        return courseByCourseId;
    }

    /**
     * 新增章节信息
     *
     * @param courseSection
     */
    @Override
    public void saveSection(CourseSection courseSection) {
        Date date = new Date();
        courseSection.setCreateTime(date);
        courseSection.setUpdateTime(date);
        courseContentMapper.saveSection(courseSection);
    }

    /**
     * 更新章节信息
     *
     * @param courseSection
     */
    @Override
    public void updateSection(CourseSection courseSection) {
        courseSection.setUpdateTime(new Date());
        courseContentMapper.updateSection(courseSection);

    }

    /**
     * 修改章节状态
     *
     * @param id
     * @param status
     */
    @Override
    public void updateSectionStatus(int id, int status) {
        CourseSection courseSection = new CourseSection();
        courseSection.setStatus(status);
        courseSection.setId(id);
        courseSection.setUpdateTime(new Date());
        courseContentMapper.updateSectionStatus(courseSection);

    }
}
