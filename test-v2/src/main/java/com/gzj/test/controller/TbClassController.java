package com.gzj.test.controller;

import com.gzj.test.entity.TbClass;
import com.gzj.test.service.TbClassService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class TbClassController {

    @Resource
    private TbClassService tbClassService;

    /*
      1. 班级
      	1. 新增，方法名/class/add，请求方式post，参数放在请求体中
      	2. 修改，方法名/class/edit，请求方式put，参数放在请求体中
      	3. 删除，方法名/class/delete，请求方式delete，参数放在请求上
     */

    /**
     * @RequestBody 主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；GET方式无请求体，
     *  所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST等方式进行提交。
     *  注：后端@RequestBody注解对应的类在将HTTP的输入流(含请求体)装配到目标类(即：@RequestBody后面的类)时，会根据json字符串中的key来匹配对应实体类的属性，
     *      如果匹配一致且json中的该key对应的值符合(或可转换为)， 实体类的对应属性的类型要求时,会调用实体类的setter方法将值赋给该属性。
     *     json字符串中，如果value为""的话，后端对应属性如果是String类型的，那么接受到的就是""，如果是后端属性的类型是Integer、Double等类型，那么接收到的就是null。
     *     json字符串中，如果value为null的话，后端对应收到的就是null。
     *     如果某个参数没有value的话，在传json字符串给后端时，要么干脆就不把该字段写到json字符串中；要么写value时， 必须有值，null 或""都行。
     */
    @PostMapping(value = "/addClass/class/add")
    public Object addClass(@RequestBody TbClass tbClass){
        int insert = tbClassService.addClass(tbClass);
        return "新增"+tbClass+"返回"+insert;
    }

    @PutMapping(value = "/editClassById/class/edit")
    public Object editClassById(@RequestBody TbClass tbClass){
        int update = tbClassService.editClassById(tbClass);
        return "修改"+tbClass+"返回"+update;
    }

    /**
     * @RequestParam  用于将指定的请求参数赋值给方法中的形参。
     * String value：请求中传入参数的名称，如果不设置value值，则会默认为该变量名。
     * boolean required：是否必需，默认为 true，即 请求中必须包含该参数，如果没有包含，将会抛出异常（可选配置）
     * String defaultValue：参数的默认值，如果请求中没有同名的参数时，该变量默认为此值。
     * 注：如果参数前写了@RequestParam(xxx)，那么前端必须有对应的xxx名字才行(不管其是否有值，
     *      当然可以通 过设置该注解的required属性来调节是否必须传)，如果没有xxx名的话，那么请求会出错，报400。
     */
    @DeleteMapping(value = "/deleteClassById/class/delete")
    public String deleteClassById(@RequestParam(value = "id", defaultValue = "1")  Long id){
        int delete = tbClassService.deleteClassById(id);
        return "删除"+id+"返回"+delete;
    }

}

