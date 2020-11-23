package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.CourseDao;
import domain.Course;
import utils.MapperUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CourseServiceImpl implements CourseService {
    @Override
    public PageInfo<Course> findByPage(Integer currentPage, Integer pageSize) {
        CourseDao mapper = MapperUtil.getMapper(CourseDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<Course> courses = mapper.findAll();
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        return pageInfo;
    }

    @Override
    public List<Course> findAll() {
        CourseDao mapper = MapperUtil.getMapper(CourseDao.class, true);
        List<Course> courses = mapper.findAll();
        MapperUtil.close();
        return courses;
    }

    @Override
    public Course findById(String id) {
        CourseDao mapper = MapperUtil.getMapper(CourseDao.class, true);
        Course course = mapper.findById(id);
        MapperUtil.close();
        return course;
    }

    @Override
    public Integer save(Course course) {
        CourseDao mapper = MapperUtil.getMapper(CourseDao.class, true);
        course.setId(UUID.randomUUID().toString());
        course.setCreateTime(new Date());
        Integer result = mapper.save(course);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(Course course) {
        CourseDao mapper = MapperUtil.getMapper(CourseDao.class, true);
        Integer result = mapper.update(course);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(String id) {
        CourseDao mapper = MapperUtil.getMapper(CourseDao.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }
}
