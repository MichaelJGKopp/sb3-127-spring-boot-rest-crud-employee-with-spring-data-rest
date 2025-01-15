package com.luv2code.springboot.demo.dao;

import com.luv2code.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // crud operations
    void create(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
    void update(Employee employee);
    void delete(Integer id);
}
