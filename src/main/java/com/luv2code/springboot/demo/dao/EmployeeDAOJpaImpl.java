package com.luv2code.springboot.demo.dao;

import com.luv2code.springboot.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

        return typedQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {

        return entityManager.find(Employee.class, id);
//        TypedQuery<Employee> typedQuery
//                = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id=:data", Employee.class);
//        typedQuery.setParameter("data", id);
//        return typedQuery.getSingleResult();
    }

    @Override
    public Employee save(Employee employee) {

        return entityManager.merge(employee); // save or update, insert returns with Id
    }

    @Override
    public void deleteById(Integer id) {

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
