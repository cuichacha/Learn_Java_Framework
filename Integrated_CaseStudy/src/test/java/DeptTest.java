import com.github.pagehelper.PageInfo;
import code1.domain.Dept;
import org.junit.Test;
import code1.service.DeptService;
import code1.service.DeptServiceImpl;

public class DeptTest {
    @Test
    public void deptTest() {
        DeptService deptService = new DeptServiceImpl();
        PageInfo<Dept> pageInfo = deptService.findByPage(1, 3);
        System.out.println(pageInfo);
    }
}
