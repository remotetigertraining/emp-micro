package com.rt.emp.empmicro.restcontroller;

import com.rt.emp.empmicro.entity.Employee;
import com.rt.emp.empmicro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class EmployeeUpdateController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping ("/emp")
    public ResponseEntity<Employee> getEmpById(@RequestBody Employee emp){
        return new ResponseEntity<>(employeeService.putById(emp).getStatusCode());
    }

}
