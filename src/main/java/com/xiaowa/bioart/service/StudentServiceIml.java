package com.xiaowa.bioart.service;

import com.xiaowa.bioart.domain.Student;
import com.xiaowa.bioart.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */
@Service
public class StudentServiceIml implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    @Transactional
    public int addStudent(Student s) {
        int i = studentMapper.insert(s);
        return i;
    }

    @Override
    public Student deleteStudent(Integer Id) {
        return null;
    }

    @Override
    public List<Student> selectStudents() {
        return null;
    }

    @Override
    public Student selectStudentById(Integer Id) {
        ;//Student s = studentMapper.selectById(Id);
        return null;
    }
}
