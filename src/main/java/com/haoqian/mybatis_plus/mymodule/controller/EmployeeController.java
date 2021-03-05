package com.haoqian.mybatis_plus.mymodule.controller;


import com.haoqian.mybatis_plus.mymodule.entity.Employee;
import com.haoqian.mybatis_plus.mymodule.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author haoqian
 * @since 2020-12-20
 */
@RestController
@RequestMapping("/mymodule/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeService.list(null);
    }

}

