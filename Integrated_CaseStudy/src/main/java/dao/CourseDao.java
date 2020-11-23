package dao;

import domain.Course;

import java.util.List;

public interface CourseDao {
    public abstract List<Course> findAll();

    public abstract Course findById(String id);

    public abstract Integer save(Course course);

    public abstract Integer update(Course course);

    public abstract Integer delete(String id);
}
