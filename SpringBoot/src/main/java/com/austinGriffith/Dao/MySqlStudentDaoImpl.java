package com.austinGriffith.Dao;


import com.austinGriffith.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository("mysql")
public class MySqlStudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate ;

    private static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("student_ID"));
            student.setName(resultSet.getString("student_NAME"));
            student.setAge(resultSet.getInt("student_AGE"));
            student.setCourse(resultSet.getString("student_COURSE"));
            student.setSchool(resultSet.getString("student_SCHOOL"));
            return student;
        }
    }


    @Override
    public Collection<Student> getAllStudents() {
            // SELECT column_name(s) from table_name
        final String sql = "SELECT student_ID, student_NAME, student_AGE, student_COURSE, student_SCHOOL FROM student_INFO" ;
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper() ) ;
                return students;
            }


    @Override
    public Student getStudentById(int id) {
        //SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT student_ID, student_NAME, student_AGE, student_COURSE, student_SCHOOL FROM student_INFO WHERE student_ID = ?" ;

        // queryForObject will get only 1 record from the specified table
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }


    @Override
    public void removeStudentById(int id) {
        //DELETE FROM table_name WHERE some_column = some_value
        final String sql = "DELETE FROM student_INFO WHERE student_ID = ?" ;
        jdbcTemplate.update(sql, id) ;

    }

    @Override
    public void updateStudent(Student student) {
        //UPDATE table_name
        // SET column=value, column2=value2,....
        // WHERE some_column = some_value
        final String sql = "UPDATE student_INFO SET student_NAME = ?, student_AGE = ?, student_COURSE = ?, student_SCHOOL = ? WHERE student_ID = ?" ;
        final int id = student.getId() ;
        final String name = student.getName() ;
        int age = student.getAge() ;
        final String course = student.getCourse() ;
        final String school = student.getSchool() ;
        jdbcTemplate.update(sql, new Object[] {name, age, course, school, id } ) ;

    }

    @Override
    public void insertStudentToDb(Student student) {
        //INSERT INTO table_name (column1, column2, column3,...) VALUES (value1, value2, value3,...)
        final String sql = "INSERT INTO student_INFO (student_ID, student_NAME, student_AGE, student_COURSE, student_SCHOOL ) VALUES (?, ?, ?, ?, ? )";
        final int id = student.getId() ;
        final String name = student.getName() ;
        final int age = student.getAge() ;
        final String course = student.getCourse() ;
        final String school = student.getSchool() ;
        jdbcTemplate.update(sql, new Object[] {id, name, age, course, school} ) ;

    }

    @Override
    public Collection<Student> getStudentBySchool(String school) {
        //SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT student_ID, student_NAME, student_AGE, student_COURSE, student_SCHOOL FROM student_INFO WHERE student_SCHOOL = ?" ;

        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), school);
        return students ;
    }

    @Override
    public Collection<Student> getStudentsByCourse(String course) {
        //SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT student_ID, student_NAME, student_AGE, student_COURSE, student_SCHOOL FROM student_INFO WHERE student_COURSE = ?" ;

        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), course);
        return students ;
    }

    @Override
    public Collection<Student> getStudentsByAge(int age) {
        //SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT student_ID, student_NAME, student_AGE, student_COURSE, student_SCHOOL FROM student_INFO WHERE student_AGE = ?" ;

        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), age);
        return students ;
    }


    @Override
    public Collection<Student> getStudentsByName(String name) {
        //SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT student_ID, student_NAME, student_AGE, student_COURSE, student_SCHOOL FROM student_INFO WHERE student_NAME = ?" ;

        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), name);
        return students ;
    }


}
