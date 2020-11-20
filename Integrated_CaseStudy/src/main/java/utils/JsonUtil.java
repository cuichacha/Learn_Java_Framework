package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static String json2Str(HttpServletRequest req) {
        BufferedReader reader = null;
        String s = null;
        try {
            reader = req.getReader();
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static <T> T Str2Bean(String str, Class<T> tClass) {
        T t = null;
        try {
            t = objectMapper.readValue(str, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T request2Bean(HttpServletRequest req, Class<T> tClass) {
        String s = json2Str(req);
        T t = Str2Bean(s, tClass);
        return t;
    }

    public static String bean2Str(Object obj) {
        String s = null;
        try {
            s = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
