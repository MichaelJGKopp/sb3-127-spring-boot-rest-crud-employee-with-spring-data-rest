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
    public void create(Employee employee) {

        entityManager.persist(employee);
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
    public void update(Employee employee) {

        entityManager.merge(employee);
    }

    @Override
    public void delete(Integer id) {

        Employee employee = findById(id);
        entityManager.remove(employee);
    }
}
