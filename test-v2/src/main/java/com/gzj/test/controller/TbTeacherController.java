package com.gzj.test.controller;

import com.gzj.test.entity.TbTeacher;
import com.gzj.test.entity.TbTeacherDetail;
import com.gzj.test.service.TbTeacherDetailService;
import com.gzj.test.service.TbTeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class TbTeacherController {

    @Resource
    private TbTeacherService tbTeacherService;

    @Resource
    private TbTeacherDetailService tbTeacherDetailService;

    /**
     * 	3. 教师
     * 	1. 新增，方法名/teacher/add，请求方式post，参数放在请求体中
     * 	2. 修改，方法名/teacher/edit，请求方式put，参数放在请求体中
     * 	3. 删除，方法名/teacher/delete，请求方式delete，参数放在请求上
     */
    @Transactional
    @PostMapping(value = "/addTeacher/teacher/add")
    public Object addTeacher(@RequestBody TbTeacher tbTeacher ){

        int insert = tbTeacherService.addTeacher(tbTeacher);

        TbTeacherDetail teacherDetail = new TbTeacherDetail();
        teacherDetail.setTeacherId(tbTeacher.getId());
        teacherDetail.setAge(tbTeacher.getTbTeacherDetail().getAge());
        teacherDetail.setGender(tbTeacher.getTbTeacherDetail().getGender());
        tbTeacherDetailService.addTeacherDetail(teacherDetail);

        tbTeacher.setTbTeacherDetail(teacherDetail);

        return "新增"+tbTeacher+"返回"+insert;
    }

    @PutMapping(value = "/saveEditTeacher/teacher/edit")
    public Object saveEditTeacher(@RequestBody TbTeacher teacher){
        int update = tbTeacherService.editTeacherById(teacher);
        return "修改"+teacher+"返回"+update;
    }

    @DeleteMapping(value = "/deleteTeacherByName/teacher/delete")
    public Object deleteTeacherByName(@RequestParam Long id ){
        int delete = tbTeacherService.deleteTeacherById(id);
        return "删除"+id+"返回"+delete;
    }

    /**
     * 5. 根据教师id查询该教师的详情
     * 	方法名/teacher/findOne，请求方式get，要求使用restFul传参
     */
    @GetMapping(value = "/queryTeacherById/teacher/findOne/{id}")
    public Object queryTeacherById(@PathVariable Long id){
        return tbTeacherService.queryTeacherDetailById(id);
    }

    @Value("${image.size}")
    private Long size ;

    @Value("${image.type}")
    private String type ;

    /**
     * 7. 上传教师头像
     * 	方法名/teacher/upload，请求方式post，要求对上传文件的大小、文件扩展名进行校验，且文件大小和扩展名的校验是可配置的。返回上传后的路径
     */
    @PostMapping("fileUpload/teacher/upload")
    public String fileUpload(MultipartFile fileImage) {

        // 判断上传的文件大小是否超出限制值
        long fileSize = fileImage.getSize();
        if (fileSize > size*1024*1024) {
            return "不允许上传超过" + (size * 1024) + "KB的头像文件";
        }

        // 判断上传的文件类型是否超出限制
        String fileType = fileImage.getContentType();
        if (!type.contains(fileType)) {
            return "不支持使用该类型的文件作为头像，允许的文件类型：" + type;
        }

        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\image\\"; // 上传后的路径
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = fileImage.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

        fileName = filePath + uuid + suffixName; // 新文件名
        File dest = new File(fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            fileImage.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}

