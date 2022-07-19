package com.gzj.controller;

import com.gzj.model.SchClass;
import com.gzj.service.SchClassService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class SchClassController {

    @Resource
    SchClassService schClassService;

    /**
     * 1. 班级
     * 	1. 新增，方法名/class/add，请求方式post，参数放在请求体中
     * 	2. 修改，方法名/class/edit，请求方式put，参数放在请求体中
     * 	3. 删除，方法名/class/delete，请求方式delete，参数放在请求上
     */
    @PostMapping(value = "/saveAddSchClass/class/add")
    public Object saveAddSchClass(@RequestParam String name){
        //封装对象
        SchClass schClass = new SchClass();
        schClass.setClassName(name);
        //调用service方法
        int i = schClassService.saveAddSchClass(schClass);

        System.out.println(schClass);
        return "新增"+schClass+"返回"+i;
    }

    @PutMapping(value = "/saveEditSchClass/class/edit")
    public Object saveEditSchClass(@RequestParam Integer id,
                                   @RequestParam String name){
        //封装对象
        SchClass schClass = new SchClass();
        schClass.setClassId(Long.valueOf(id));
        schClass.setClassName(name);
        //调用service方法
        int i = schClassService.saveEditSchClass(schClass);
        return "修改"+schClass+"返回"+i;
    }

    @DeleteMapping(value = "/deleteClassByNumbessssr/class/delete")
    public String deleteClassByNumber(@RequestParam String name){
        int i = schClassService.deleteClassByNumber(name);
        return "删除"+name+"返回"+i;
    }
}
