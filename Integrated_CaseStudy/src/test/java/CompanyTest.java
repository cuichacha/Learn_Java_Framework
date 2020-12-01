import com.github.pagehelper.PageInfo;
import code1.domain.Company;
import org.junit.Test;
import code1.service.CompanyService;
import code1.service.CompanyServiceImpl;

public class CompanyTest {

    @Test
    public void companyTest() {
        CompanyService companyService = new CompanyServiceImpl();
        PageInfo<Company> pageInfo = companyService.findByPage(1, 3);
        System.out.println(pageInfo);
    }
}
