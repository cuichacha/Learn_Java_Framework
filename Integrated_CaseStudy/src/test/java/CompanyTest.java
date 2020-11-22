import com.github.pagehelper.PageInfo;
import domain.Company;
import org.junit.Test;
import service.CompanyService;
import service.CompanyServiceImpl;

public class CompanyTest {

    @Test
    public void companyTest() {
        CompanyService companyService = new CompanyServiceImpl();
        PageInfo<Company> pageInfo = companyService.findByPage(1, 3);
        System.out.println(pageInfo);
    }
}
