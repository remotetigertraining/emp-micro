package com.rt.emp.empmicro.service;

import com.rt.emp.empmicro.entity.Employee;
import com.rt.emp.empmicro.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmps(){
       return employeeRepo.findAll().stream().toList();
    }

    public Employee getById(Integer Id) {
        return employeeRepo.getReferenceById(Id);
    }

    public ResponseEntity<Employee> putById(Employee emp) {
           try{
               Employee UpdatedEmployee=employeeRepo.save(emp);
               return new ResponseEntity<>(UpdatedEmployee, HttpStatus.OK);
           }catch (Exception e){
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }




    }
}
