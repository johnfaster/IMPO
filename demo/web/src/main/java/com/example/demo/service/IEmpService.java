package com.example.demo.service;

import com.example.demo.domain.ExampleExcelEmp;
import com.example.demo.mapper.ExampleExcelEmpMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

public interface IEmpService {
    public void insert(Long id,String name);
    public void importEmp();
}
