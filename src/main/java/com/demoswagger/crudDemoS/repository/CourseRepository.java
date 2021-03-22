package com.demoswagger.crudDemoS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoswagger.crudDemoS.model.Course;



public interface CourseRepository extends JpaRepository<Course, Integer>{
List<Course> findByNameContaining(String key);
}
