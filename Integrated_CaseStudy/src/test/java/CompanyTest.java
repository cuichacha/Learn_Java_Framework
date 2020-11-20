import com.github.pagehelper.PageInfo;
import domain.Company;
import org.junit.Test;
import service.CompanyService;
import service.CompanyServiceImpl;
import web.controller.CompanyController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompanyTest extends HttpServlet {

    @Test
    public void companyTest() {
        CompanyService companyService = new CompanyServiceImpl();
        PageInfo<Company> pageInfo = companyService.findByPage(1, 3);
        System.out.println(pageInfo);
    }
}
