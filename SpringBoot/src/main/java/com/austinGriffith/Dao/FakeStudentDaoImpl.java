package com.austinGriffith.Dao;

import com.austinGriffith.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {


    private static Map<Integer, Student> students ;

    static {

        students = new HashMap<Integer, Student>() ;


        students.put(1, new Student(1, "Austin", 22, "Math", "Yale"))  ;
        students.put(2, new Student(2, "Jeff", 25, "Science", "Brown")) ;
        students.put(3, new Student(3, "Ming", 30, "English", "Boulder")) ;
        students.put(4, new Student(4, "Leo", 27, "Art", "Denver")) ;
        students.put(5, new Student(5, "Justin", 35, "History", "San Diego")) ;
        students.put(6, new Student(6, "Houston", 32, "History", "Yale")) ;
        students.put(7, new Student(7, "Michael", 36, "Photography", "USC")) ;
        students.put(8, new Student(8, "Kindall", 21, "Adult Films", "Hollywood")) ;
        students.put(9, new Student(9, "Rebecca", 18, "Underwater sewing", "Miami")) ;
        students.put(10, new Student(10, "Kristen", 32, "Yoga", "Orange County College")) ;
    }

    @Override
    public Collection<Student> getAllStudents() {
        return this.students.values() ;
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id) ;
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id) ;
    }

    @Override
    public void updateStudent(Student student) {            //implements updating the student to database
        Student appNexus_student = students.get(student.getId());
        appNexus_student.setCourse(student.getCourse()) ;
        appNexus_student.setName(student.getName()) ;
        //appNexus_student.setAge(student.getAge()) ;
        appNexus_student.setSchool(student.getSchool()) ;
        students.put(student.getId(), student) ;

    }

    @Override
    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(), student) ;
    }


    @Override
    public Collection<Student> getStudentBySchool(String school) {

        Set<Student> studentsForParticularSchool = new HashSet<>();
        for( Student eachStudent: students.values()) {
            if(eachStudent.getSchool().equalsIgnoreCase(school)) {
                studentsForParticularSchool.add(eachStudent);
            }
        }
        return studentsForParticularSchool;
    }


    @Override
    public Collection<Student> getStudentsByCourse(String course) {

        Set<Student> studentsByCourse = new HashSet<>();
        for (Student eachStudent: students.values()) {
            if (eachStudent.getCourse().equalsIgnoreCase(course)) {
                studentsByCourse.add(eachStudent) ;
            }
        }
        return studentsByCourse;
    }


    @Override
    public Collection<Student> getStudentsByName(String name) {

        Set<Student> studentsByName = new HashSet<>();
        for (Student eachStudent: students.values()) {
            if (eachStudent.getCourse().equalsIgnoreCase(name)) {
                studentsByName.add(eachStudent) ;
            }
        }
        return studentsByName;
    }


    @Override
    public Collection<Student> getStudentsByAge(int age) {

        Set<Student> studentsByAge = new HashSet<>() ;
        for (Student eachStudent: students.values()) {
            if (eachStudent.getAge() == (age)) {
                studentsByAge.add(eachStudent) ;
            }
        }
        return studentsByAge;
    }


}
