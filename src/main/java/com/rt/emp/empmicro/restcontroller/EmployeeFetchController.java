package com.rt.emp.empmicro.restcontroller;

import com.rt.emp.empmicro.entity.Employee;
import com.rt.emp.empmicro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
public class EmployeeFetchController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emps")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAllEmps();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Integer Id){
        return new ResponseEntity<>(employeeService.getById(Id),HttpStatus.FOUND);
    }



}
