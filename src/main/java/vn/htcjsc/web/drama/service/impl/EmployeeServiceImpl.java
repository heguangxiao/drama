/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.htcjsc.web.drama.dao.EmployeeDao;
import vn.htcjsc.web.drama.model.Employee;
import vn.htcjsc.web.drama.service.EmployeeService;

/**
 *
 * @author HTC-PC
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() { 
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(long id) {
        return employeeDao.findById(id);
    }

    @Override
    public boolean add(Employee t) {
        return employeeDao.add(t);
    }

    @Override
    public boolean update(Employee t) {
        return employeeDao.update(t);
    }

    @Override
    public boolean deleteById(long id) {
        return employeeDao.deleteById(id);
    }
    
}
