package com.demoswagger.crudDemoS.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoswagger.crudDemoS.model.Course;
import com.demoswagger.crudDemoS.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("api")
public class CourseController {


	@Autowired
	private CourseService courseService;
	
	@Operation(summary = "Add Course")
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course co) {
		co.setId(0);
		return courseService.addCourse(co);
	}
	@Operation(summary = "Update Course")
	@PutMapping("/courses{id}")
	public Course updateCourse(@PathVariable int id,@RequestBody Course co) {
		co.setId(id);
		return courseService.addCourse(co);
	}
	
	@Operation(summary = "Get All Courses")
	@GetMapping("/courses")
	public List<Course> getCourses() {
		
		return courseService.findAll();
	} 
	

	@Operation(summary = "Get Course by course name")
	@GetMapping("/courses/{keyword}")
	public List<Course> getCourseByBySearch(@PathVariable String keyword){
		
		if (keyword ==null || keyword.equals("") ) {
			
			return courseService.findAll();
		}else {
			return courseService.findByNameContaining(keyword);
		}
		
	}
	
	@Operation(summary = "Get Course by course id")
	@GetMapping("/course/{id}")
	public Course getCourseById(@PathVariable int id){
		
			return courseService.findbyid(id);	
	}
	

	@Operation(summary = "Delete Course")
	@DeleteMapping("/courses/{id}")
	public String deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
		
		return "Course ID "+ id+" is Deleted";
	}
	
}
