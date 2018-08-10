package com.austinGriffith.Dao;

import com.austinGriffith.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentDao {

    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudentToDb(Student student);

    Collection<Student> getStudentBySchool(String school) ;

    Collection<Student> getStudentsByCourse(String course) ;

    Collection<Student> getStudentsByAge(int age) ;

    Collection<Student> getStudentsByName(String name);
}
