package com.demoswagger.crudDemoS.service;

import java.util.List;

import com.demoswagger.crudDemoS.model.Course;

public interface CourseService {

	public List<Course> findAll();
	public Course findbyid(int id);
	public Course addCourse(Course cor);
	public void deleteCourse(int id);
	public List<Course> findByNameContaining(String key);
}
