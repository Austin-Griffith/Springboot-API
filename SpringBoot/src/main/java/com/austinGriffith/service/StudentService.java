package com.austinGriffith.service;

import com.austinGriffith.Dao.FakeStudentDaoImpl;
import com.austinGriffith.Dao.MySqlStudentDaoImpl;
import com.austinGriffith.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class StudentService {

    @Autowired
    @Qualifier("mysql")

    private MySqlStudentDaoImpl mySqlStudentDaoImpl;

    public Collection<Student> getAllStudents() {
        return this.mySqlStudentDaoImpl.getAllStudents() ;
    }

    public Student getStudentById(int id) {
        return this.mySqlStudentDaoImpl.getStudentById(id) ;
    }

    public void removeStudentById(int id) {
        this.mySqlStudentDaoImpl.removeStudentById(id) ;
    }

    public void updateStudent(Student student) {
        this.mySqlStudentDaoImpl.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.mySqlStudentDaoImpl.insertStudentToDb(student) ;
    }

    public Collection<Student> getStudentBySchool(String school) {return this.mySqlStudentDaoImpl.getStudentBySchool(school) ; }

    public Collection<Student> getStudentsByCourse(String course) {return this.mySqlStudentDaoImpl.getStudentsByCourse(course) ; }

    public Collection<Student> getStudentsByAge(int age) {return this.mySqlStudentDaoImpl.getStudentsByAge(age) ; }

    public Collection<Student> getStudentsByName(String name) {return this.mySqlStudentDaoImpl.getStudentsByName(name) ; }



//    private FakeStudentDaoImpl fakeStudentDaoImpl;
//
//    public Collection<Student> getAllStudents() {
//        return this.fakeStudentDaoImpl.getAllStudents() ;
//    }
//
//    public Student getStudentById(int id) {
//        return this.fakeStudentDaoImpl.getStudentById(id) ;
//    }
//
//    public void removeStudentById(int id) {
//        this.fakeStudentDaoImpl.removeStudentById(id) ;
//    }
//
//    public void updateStudent(Student student) {
//        this.fakeStudentDaoImpl.updateStudent(student);
//    }
//
//    public void insertStudent(Student student) {
//        this.fakeStudentDaoImpl.insertStudentToDb(student) ;
//    }
//
//    public Collection<Student> getStudentBySchool(String school) {return this.fakeStudentDaoImpl.getStudentBySchool(school) ; }
//
//    public Collection<Student> getStudentsByCourse(String course) {return this.fakeStudentDaoImpl.getStudentsByCourse(course) ; }
//
//    public Collection<Student> getStudentsByAge(int age) {return this.fakeStudentDaoImpl.getStudentsByAge(age) ; }

}


