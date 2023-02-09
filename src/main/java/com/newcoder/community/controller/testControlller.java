package com.newcoder.community.controller;

import com.newcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuyang
 * @create 2023-02-07 10:01
 */

@Controller
@RequestMapping("/test")
public class testControlller {

    @Autowired
    private AlphaService alphaService;


    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }


    @GetMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }




    // GET请求

    // /students?current=1&limit=20
    @GetMapping("/students")
    @ResponseBody
    public String getStudents(
            //required = false 表示可以不传，默认为1
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit
    ){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }


    // /student/123
    @GetMapping("/student/{id}")
    @ResponseBody
    public String getStudMent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }



    // POST请求
    @PostMapping("/student")
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }



    // 响应HTML数据
    @GetMapping("/teacher")
    public ModelAndView getTeacher(){
        ModelAndView view = new ModelAndView();
        view.addObject("name","张三");
        view.addObject("age",20);
        view.setViewName("/demo/view");
        return view;
    }

    @GetMapping("/school")
    public String getSchool(Model model){
        model.addAttribute("name","北京交通");
        model.addAttribute("age",90);
        return "/demo/view";
    }



    // 响应JSON数据(异步请求)
    // Java对象 -> JSON字符串 -> JS对象
    @GetMapping("/emp")
    @ResponseBody
    public Map<String,Object> getEmp(){
        HashMap<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        return emp;
    }


    @GetMapping("/emps")
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "李四");
        emp.put("age", 24);
        emp.put("salary", 9000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "王五");
        emp.put("age", 25);
        emp.put("salary", 10000.00);
        list.add(emp);

        return list;
    }







}