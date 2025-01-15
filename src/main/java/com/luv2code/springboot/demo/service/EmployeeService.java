package com.luv2code.springboot.demo.service;

import com.luv2code.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
