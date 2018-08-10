package com.austinGriffith.entity;


import javax.persistence.*;

@Entity
@Table(name = "student_INFO")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_ID")
    private int id;

    @Column(name = "student_NAME")
    private String name;

    @Column(name = "student_AGE")
    private int age ;
    @Column(name = "student_COURSE")
    private String course;
    @Column(name = "student_SCHOOL")
    private String school ;

    public Student(int id, String name, int age, String course, String school) {            //constructor
        this.id = id;
        this.name = name;
        this.age = age ;
        this.course = course;
        this.school = school ;
    }

    public Student() { }                           // default constructor


    public int getId() {            //getter
        return id;
    }

    public void setId(int id) {     //setter
        this.id = id;
    }

    public String getName() {       //getter
        return name;
    }

    public void setName(String name) {      //setter
        this.name = name;
    }

    public String getCourse() {         //getter
        return course ;
    }

    public void setCourse(String course) {         //setter
        this.course = course ;
    }

    public void setSchool(String school) {this.school = school ;}

    public String getSchool() { return school ; }

    public void setAge(int age) { this.age = age ; }

    public int getAge() { return age ; }


}
