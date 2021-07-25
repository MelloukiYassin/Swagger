package com.yascode.swagger.controller;

import com.yascode.swagger.model.Employee;
import com.yascode.swagger.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
/*  http://localhost:8081/api  */
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /*  http://localhost:8081/api/save  */
    @PostMapping("/save")
    public void save(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    /*  http://localhost:8081/api/show  */
    @GetMapping("/show/{id}")
    public Employee show(@PathVariable(value = "id") Long id){
        return employeeRepository.findById(id).get();
    }

    /*  http://localhost:8081/api/delete/{id}  */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        employeeRepository.deleteById(id);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }





}
