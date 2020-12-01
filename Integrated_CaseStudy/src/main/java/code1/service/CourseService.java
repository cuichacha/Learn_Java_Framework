package code1.service;

import com.github.pagehelper.PageInfo;
import code1.domain.Course;

import java.util.List;


public interface CourseService {
    public abstract PageInfo<Course> findByPage(Integer currentPage, Integer pageSize);

    public abstract List<Course> findAll();

    public abstract Course findById(String id);

    public abstract Integer save(Course course);

    public abstract Integer update(Course course);

    public abstract Integer delete(String id);
}
