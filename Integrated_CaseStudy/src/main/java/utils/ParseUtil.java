package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

public class ParseUtil {
    private ParseUtil() {
    }

    public static void parse(HttpServletRequest req, HttpServletResponse resp, Object object) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String operation = req.getParameter("operation");

        try {
            Method declaredMethod = object.getClass().getDeclaredMethod(operation, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(object, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
