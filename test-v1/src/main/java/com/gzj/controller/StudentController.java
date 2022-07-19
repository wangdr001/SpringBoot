package com.gzj.controller;

import com.github.pagehelper.PageInfo;
import com.gzj.model.Student;
import com.gzj.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    /**
     * 	1. 条件分页查询，方法名/student/list，请求方式get，查询条件
     * 		- name模糊匹配
     * 		- class_id精确匹配
     * 		- gender精确匹配
     */
    @Resource
    private StudentService studentService;

    // 多个查询(分页）
    @GetMapping("/queryStudentByConditionForPage/student/list")
    public PageInfo<Student> queryStudentByConditionForPage(String name, String id, String gender,
                                                            @RequestParam("pageNum") int pageNum,
                                                            @RequestParam("pageSize") int pageSize) {
        Map<String,Object> map=new HashMap<>();
        map.put("studentName",name);
        map.put("studentGender",gender);
        map.put("classId",id);
        return studentService.queryStudentByConditionForPage(map,pageNum,pageSize);
    }

    /**
     * 	2. 新增，方法名/student/add，请求方式post，参数放在请求体中
     * 	3. 修改，方法名/student/edit，请求方式put，参数放在请求体中
     * 	4. 删除，方法名/student/delete，请求方式delete，参数放在请求上
     */
    @PostMapping(value = "/saveAddStudent/student/add")
    public Object saveAddStudent(@RequestParam String name ,
                                 @RequestParam Integer gender,
                                 @RequestParam Integer id  ){
        //封装参数
        Student student = new Student();
        student.setStudentName(name);
        student.setStudentGender(gender);
        student.setClassId(Long.valueOf(id));
        //调用service方法
        int i = studentService.saveAddStudent(student);
        return "新增"+student+"返回"+i;
    }

    @PutMapping(value = "/saveEditStudent/student/edit")
    public Object saveEditStudent(@RequestParam Integer id,
                                  @RequestParam String name,
                                  @RequestParam Integer gender ,
                                  @RequestParam Integer classId ){
        //封装参数
        Student student = new Student();
        student.setStudentId(Long.valueOf(id));
        student.setStudentName(name);
        student.setStudentGender(gender);
        student.setClassId(Long.valueOf(classId));
        //调用service方法
        int i = studentService.saveEditStudent(student);
        return "修改"+student+"返回"+i;
    }

    @DeleteMapping(value = "/deleteStudentByName/student/delete")
    public Object deleteStudentByName(@RequestParam String name){
        int i = studentService.deleteStudentByName(name);
        return "删除"+name+"返回"+i;
    }

    /**
     *  4. 根据教师id查询该教师所有的学生的信息
     *  	方法名/student/getByTeacherId，请求方式get，要求使用rest
     */
    @GetMapping(value = "/queryStudentByTeacherId/student/getByTeacherId")
    public Object queryStudentByTeacherId(HttpServletRequest request){
        String id = request.getParameter("id");
        List<Student> student = studentService.queryStudentByTeacherId(id);
        for(Student str:student) {
            System.out.println(str);
        }
        return student ;
    }

    /**
     * 6. 根据班级id的集合查询这些班级中所有学生的信息
     *     方法名/student/getByClassIds，请求方式get，要求后台接收参数时用List接收
     */
    @GetMapping(value = "/queryStudentByClassId/student/getByClassIds")
    public Object queryStudentByClassIds(String[] id){
        List<Student> student = studentService.queryStudentByClassIds(id);
        return student ;
    }


}
