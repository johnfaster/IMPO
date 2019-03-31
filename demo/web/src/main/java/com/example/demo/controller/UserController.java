package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;
    private UserController(UserRepository userRepository){
    this.userRepository = userRepository;
    }
    @Autowired
    private IEmpService empService;
    @Autowired(required=false)
    private HttpServletResponse res;
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
    @RequestMapping("/person/export")
    public void exportEmp(){
        empService.importEmp();
    }
    @PostMapping("/person/import")
    public List<Map<String,String>> importSpareInfo(){
        String[][] str = {
                {"1","0000000000"},
                {"2","000000001"},
                {"3","0000000002"}
        };
        String[][] strs = {
                {"0000000000","方法","放的地方","金海环境"},
                {"11","方法","放的地方","金海环境"},
                {"12","方法","放的地方","金海环境"},
                {"0000000001","方法","放的地方","金海环境"},
                {"21","方法","放的地方","金海环境"},
                {"22","方法","放的地方","金海环境"},
                {"0000000002","方法","放的地方","金海环境"},
                {"31","方法","放的地方","金海环境"},
                {"32","方法","放的地方","金海环境"}
        };
        Long start = System.currentTimeMillis();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Map<String,String> map = null;
        for (int m = 0;m<str.length;m++){
            for (int i = 0;i<strs.length;i++){//循环二维数组第一层
                for (int j = 0;j<strs[i].length;j++){//循环二维数组第二层
                    String matnr = str[m][1];
                    if(str[m][1].equals(strs[i][0])&&(i+2)<strs.length){
                        map = new HashMap<String,String>();
                        map.put("id",str[m][0]);
                        map.put("o",strs[i][j]);
                        map.put("y",strs[i+1][j]);
                        map.put("t",strs[i+2][j]);
                        list.add(map);
                    }
                }
            }
        }
        Long end = System.currentTimeMillis();
        Long cost = (end-start)/1000;
        System.err.println("耗时"+cost+"====="+list.toString());
        return list;
    }
}
