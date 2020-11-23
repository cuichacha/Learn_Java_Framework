package service;

import com.github.pagehelper.PageInfo;
import domain.Course;


public interface CourseService {
    public abstract PageInfo<Course> findByPage(Integer currentPage, Integer pageSize);

    public abstract Course findById(String id);

    public abstract Integer save(Course course);

    public abstract Integer update(Course course);

    public abstract Integer delete(String id);
}
