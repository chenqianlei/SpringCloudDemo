package com.clientdemo.controller;

import com.clientdemo.entity.Student;
import com.clientdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable long id){
        return  studentRepository.findById(id);
    }

    @PostMapping("/save")
    public String save(@RequestBody Student student){
        try {
            System.out.println(student.getId());
            studentRepository.saveOrUpdate(student);
            return "操作成功！";
        }catch (Exception e){
            return "操作失败！";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Student student){
        try {
            studentRepository.saveOrUpdate(student);
            return "操作成功！";
        }catch (Exception e){
            return "操作失败！";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        try {
            studentRepository.deleteById(id);
            return "操作成功！";
        }catch (Exception e){
            return "操作失败！";
        }
    }

    @GetMapping("/index")
    public String index(){
        return this.port;
    }
}
