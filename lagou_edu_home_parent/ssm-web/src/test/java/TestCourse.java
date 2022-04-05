import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 0:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCourse {

    @Autowired
    private CourseContentService courseContentService;


    @Test
    public void test1(){
        List<CourseSection> list = courseContentService.findSectionAndLessonByCourseId(7);
        System.out.println("************************************");
        list.forEach(System.out::println);
        System.out.println("************************************");

    }
}
