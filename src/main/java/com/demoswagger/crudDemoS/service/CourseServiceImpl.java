package com.demoswagger.crudDemoS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoswagger.crudDemoS.model.Course;
import com.demoswagger.crudDemoS.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		
		return courseRepository.findAll();
	}

	@Override
	public Course findbyid(int id) {
		 
		Optional<Course> result =courseRepository.findById(id);
				
		Course co=null;
		if (result.isPresent()) {
			co=result.get();
			}	
	return co;
	}

	@Override
	public Course addCourse(Course cor) {
		return courseRepository.save(cor);
		
	}

	@Override
	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
		
	}

	@Override
	public List<Course> findByNameContaining(String key) {
		// TODO Auto-generated method stub
		return courseRepository.findByNameContaining(key);
	}


}
