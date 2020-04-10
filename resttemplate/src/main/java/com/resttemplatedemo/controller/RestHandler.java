package com.resttemplatedemo.controller;

import com.resttemplatedemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public String save(@RequestBody Student student){
        return restTemplate.postForObject("http://localhost:8010/student/save",student,String.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/student/update",student);
    }
}

