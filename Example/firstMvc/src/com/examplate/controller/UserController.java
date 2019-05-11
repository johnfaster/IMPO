package com.examplate.controller;

import com.examplate.User;
import com.examplate.UserCustom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("hello")
    public String write(){
        return "basic";
    }
    @RequestMapping("receInt")
    public String receieveInt(Integer id){
        System.out.println(id);
        return "success";
    }
    @RequestMapping("receStr")
    public String receieveInt(String name){
        System.out.println(name);
        return "success";
    }
    @RequestMapping("receArray")
    public String receArray(Integer[] ids){
        System.out.println(ids);
        return "success";
    }
    @RequestMapping("receUser")
    public String receUser(User user){
        System.out.println(user);
        return "success";
    }
    @RequestMapping("receBzUser")
    public String receUser(UserCustom userCustom){
        System.out.println(userCustom);
        return "success";
    }
    @RequestMapping("receList")
    public String receList(UserCustom userCustom){
        System.out.println(userCustom);
        return "success";
    }
    @RequestMapping("receMap")
    public String receMap(UserCustom userCustom){
        System.out.println(userCustom);
        return "success";
    }
    @RequestMapping("list")
    public String list(Model model) {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setUsername("张三丰");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("深圳市");
        userList.add(user);
        User user1 = new User();
        user1.setId(2);
        user1.setUsername("流川枫");
        user1.setBirthday(new Date());
        user1.setSex("男");
        user1.setAddress("深圳市");
        userList.add(user1);
        User user2 = new User();
        user2.setId(3);
        user2.setUsername("张君宝");
        user2.setBirthday(new Date());
        user2.setSex("男");
        user2.setAddress("深圳市");
        userList.add(user2);
        model.addAttribute("userList",userList);
        return "userList";
    }
        @RequestMapping("updateById")
    public String updateById(Integer id, Model model){
        User user = new User();
        user.setId(id);
        user.setUsername("东方不败");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("深圳市");
        model.addAttribute("user",user);
        return "edit";
    }
    @RequestMapping("forward")
    public String forward(){
        return "forward:/rest/list.do";
    }
    @RequestMapping("redirect")
    public String redirect(){
        return "redirect:/rest/list.do";
    }
    @RequestMapping("toJson")
    public String toJson(){
        return "returnJson";
    }
    @RequestMapping("requestJson")
    public @ResponseBody User requestJson(@RequestBody User user){
        System.out.println(user);
        return user;
    }
    @RequestMapping("returnPo")
    public @ResponseBody User requestPo(User user){
        System.out.println(user);
        return user;
    }
}
