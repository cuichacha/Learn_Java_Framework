import domain.Course;
import org.junit.Test;
import service.CourseService;
import service.CourseServiceImpl;

public class CourseTest {
    @Test
    public void Test() {
        CourseService courseService = new CourseServiceImpl();
        Course course = new Course();

        Course course1 = courseService.findById("bd18b1ff-541a-4587-a9a7-8c11ffb8a4e9");
        System.out.println(course1);
    }
}
