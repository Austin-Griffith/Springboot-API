package com.austinGriffith.controller;

import com.austinGriffith.entity.Student;
import com.austinGriffith.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService ;

    //GET all studnets request is working
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return this.studentService.getAllStudents() ;
    }

    //GET request by ID is working
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id) ;
    }




    @RequestMapping(value = "/school/{school}" , method = RequestMethod.GET)
    public Collection<Student> getStudentBySchool(@PathVariable("school") String school) {
        return studentService.getStudentBySchool(school) ; }

    @RequestMapping(value = "/course/{course}" , method = RequestMethod.GET)
    public Collection<Student> getStudentsByCourse(@PathVariable("course") String course) {
        return studentService.getStudentsByCourse(course) ; }



    @RequestMapping(value = "/name/{name}" , method = RequestMethod.GET)
    public Collection<Student> getStudentsByName(@PathVariable("name") String name) {
        return studentService.getStudentsByName(name) ; }


    //GET request to get student by age is working
    @RequestMapping(value = "/age/{age}", method = RequestMethod.GET)
    public Collection<Student> getStudentsByAge(@PathVariable("age") int age) {
        return studentService.getStudentsByAge(age) ; }

    //DELETE request is working --> takes out a student from database
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id) {
        studentService.removeStudentById(id) ;
    }


    //PUT request to update a students info (name, age, course, school )is working
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudentById(@RequestBody Student student) {
        studentService.updateStudent(student);
    }




    //POST request to insert a new student into database is working
    // POST request does not auto generate student_ID's
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
    public void insertStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
    }




}
