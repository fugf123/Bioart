package com.xiaowa.bioart.service;

import com.xiaowa.bioart.domain.Student;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */
public interface IStudentService {

    int addStudent(Student s);

    Student deleteStudent(Integer Id);

    List<Student> selectStudents();

    Student selectStudentById(Integer Id);


}
