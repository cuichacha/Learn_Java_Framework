package web.filters;


import service.UserService;
import service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(value = {"/system/*", "/store/*"})
public class AuthorizationFilter implements Filter {
    private FilterConfig filterConfig;
    private UserService userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String queryString = req.getQueryString();
        String originalRequestURI = req.getRequestURI();
        String modifiedRequestURI = originalRequestURI.substring(11);
        String requestURI = modifiedRequestURI + "?" +queryString;
        String id = (String) req.getSession().getAttribute("UserId");
        List<String> urls = userService.findModuleUrlsByUserId(id);
        boolean isContained = urls.contains(requestURI);
        if (isContained) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.getRequestDispatcher("/unauthorized.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
