package com.luv2code.springboot.demo.service;

import com.luv2code.springboot.demo.dao.EmployeeDAO;
import com.luv2code.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        employeeDAO.delete(id);
    }
}
