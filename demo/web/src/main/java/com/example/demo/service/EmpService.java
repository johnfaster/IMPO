package com.example.demo.service;

import com.example.demo.domain.ExampleExcelEmp;
import com.example.demo.domain.User;
import com.example.demo.mapper.ExampleExcelEmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class EmpService implements  IEmpService{
    private ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();
    @Autowired
    private final static AtomicInteger idGenerator = new AtomicInteger();
    @Autowired
private ExampleExcelEmpMapper exampleExcelEmpMapper;
    public void insert(String name){
        ExampleExcelEmp emp = new ExampleExcelEmp();
        Integer id = idGenerator.incrementAndGet();
        emp.setEmpname(name);
        emp.setEmpid(id.longValue());
        emp.setOrgid(id.longValue());
        emp.setEmpcode("005");
        exampleExcelEmpMapper.insert(emp);
        System.out.printf("用户对象：%s保存成功！\n",emp);
    }
}
