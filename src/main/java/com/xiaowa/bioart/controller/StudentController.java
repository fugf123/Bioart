package com.xiaowa.bioart.controller;

import com.xiaowa.bioart.domain.Student;
import com.xiaowa.bioart.domain.Teacher;
import com.xiaowa.bioart.mapper.TeacherMapper;
import com.xiaowa.bioart.service.IStudentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private TeacherMapper teacherMapper;

    @RequestMapping(value="/addStudent",method = RequestMethod.GET)
    public String addStudent(HttpServletRequest request){
        Student s = new Student();
        s.setAddress("河南89");
        s.setName("lisi");
        s.setAge(10);
        int row = studentService.addStudent(s);
        System.out.println(row);
        return "student"+row;
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String Hello(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("name","123");
        System.out.println("method:hello:"+session.getAttribute("name"));
        Teacher s = new Teacher();
        s.setAddress("河南34");
//        s.setName("lisi");
//        s.setAge(10);
//        int row = teacherMapper.insert(s);
        List<Teacher> list = teacherMapper.selectByRowBounds(null,new RowBounds(0,5));
//        Page<Teacher> page = new Page<>(1, 5);
//
//        List<Teacher> list = teacherMapper.selectPage(page, null).getRecords();


        return "hello"+list.size();
    }
}
