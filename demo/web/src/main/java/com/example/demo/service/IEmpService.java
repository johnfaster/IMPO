package com.example.demo.service;

import com.example.demo.domain.ExampleExcelEmp;
import com.example.demo.mapper.ExampleExcelEmpMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface IEmpService {
    public void insert(Long id,String name);
}
