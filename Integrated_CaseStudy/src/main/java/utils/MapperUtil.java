package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MapperUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    private MapperUtil() {
    }

    static {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public static<T> T getMapper(Class<T> tClass, boolean autoCommit) {
        T mapper;
        if (threadLocal.get() != null) {
            SqlSession sqlSession = threadLocal.get();
            mapper = sqlSession.getMapper(tClass);
            return mapper;
        } else {
            SqlSession sqlSession = sqlSessionFactory.openSession(autoCommit);
            threadLocal.set(sqlSession);
            mapper = sqlSession.getMapper(tClass);
            return mapper;
        }
    }

    public static void close() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
        }
        threadLocal.remove();
    }

    public static void commit() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }

    public static void rollback() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }
}
