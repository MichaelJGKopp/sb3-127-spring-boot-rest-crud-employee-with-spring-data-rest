package com.luv2code.springboot.demo.rest;

import com.luv2code.springboot.demo.entity.Employee;
import com.luv2code.springboot.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
//    private List<Employee> employees;

//    @PostConstruct
//    public void loadData() {
//
//        employees = employeeDAO.readAll();
//    }

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    void createEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);
    }

    @GetMapping("/employees")
    List<Employee> getEmployees() {

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    Employee getEmployee(@PathVariable int employeeId) {

        return employeeService.findById(employeeId);
    }

    @PutMapping("/employees")
    void updateEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    void deleteEmployee(@PathVariable int employeeId) {

        employeeService.deleteById(employeeId);
    }
}
