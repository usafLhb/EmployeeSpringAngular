package tech.getarrays.employeemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee add(Employee employee){
        employee.setEmloyeeCode(java.util.UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> get(){
        return employeeRepo.findAll();
    }
    public Employee update(Employee emp){
        return employeeRepo.save(emp);
    }
    public void delete(Long id){
         employeeRepo.deleteById(id);
    }
    public Employee findByid(Long id){
        return employeeRepo.findById(id).orElseThrow(()->new UserNotFoundException("User by  this id  does not  existe"));
    }
}
