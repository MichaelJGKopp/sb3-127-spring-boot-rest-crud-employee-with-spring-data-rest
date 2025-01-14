package com.luv2code.springboot.demo.dao;

import com.luv2code.springboot.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(Employee employee) {

        entityManager.persist(employee);
    }

    @Override
    public List<Employee> readAll() {

        TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

        return typedQuery.getResultList();
    }

    @Override
    public Employee readById(int id) {

        return entityManager.find(Employee.class, id);
//        TypedQuery<Employee> typedQuery
//                = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id=:data", Employee.class);
//        typedQuery.setParameter("data", id);
//        return typedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Employee employee) {

        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Employee employee = readById(id);
        entityManager.remove(employee);
    }
}
