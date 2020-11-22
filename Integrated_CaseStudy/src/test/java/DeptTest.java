import com.github.pagehelper.PageInfo;
import domain.Company;
import domain.Dept;
import org.junit.Test;
import service.CompanyService;
import service.CompanyServiceImpl;
import service.DeptService;
import service.DeptServiceImpl;

public class DeptTest {
    @Test
    public void deptTest() {
        DeptService deptService = new DeptServiceImpl();
        PageInfo<Dept> pageInfo = deptService.findByPage(1, 3);
        System.out.println(pageInfo);
    }
}
