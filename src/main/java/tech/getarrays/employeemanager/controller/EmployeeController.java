package tech.getarrays.employeemanager.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins="*")
public class EmployeeController {
    private final EmployeeService serviceEmp;

    public EmployeeController(EmployeeService serviceEmp) {
        this.serviceEmp = serviceEmp;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> get(){
        List<Employee> emp=serviceEmp.get();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee emp=serviceEmp.findByid(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> post(@RequestBody Employee employee){
        Employee emp=serviceEmp.add(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        Employee emp=serviceEmp.update(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        serviceEmp.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
