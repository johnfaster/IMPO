package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;
    private UserController(UserRepository userRepository){
    this.userRepository = userRepository;
    }
    @Autowired
    private IEmpService empService;
    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        if(userRepository.save(user)){
            System.out.printf("用户对象：%s保存成功！\n",user);
        }
        return user;
    }
    @PostMapping("/person/insert")
    public void insert(@RequestParam Long id,String name){
        empService.insert(id,name);
    }
    @PostMapping("/person/export")
    public void exportEmp(){
        empService.importEmp();
    }
}
