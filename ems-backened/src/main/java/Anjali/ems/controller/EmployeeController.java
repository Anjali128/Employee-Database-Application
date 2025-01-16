package Anjali.ems.controller;

import Anjali.ems.dto.EmployeDto;
import Anjali.ems.entity.Employee;
import Anjali.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("api/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity <EmployeDto> createEmployee(@RequestBody EmployeDto employeDto){

        EmployeDto savedEmployee = employeeService.createEmployee(employeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeDto employeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeDto);
    }

    //Build Get All Employees REST API
    @GetMapping()
    public ResponseEntity<List<EmployeDto>> getAllWmployee(){
        List<EmployeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build update Employee REST APT
    @PutMapping("{id}")
    public ResponseEntity<EmployeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                     @RequestBody EmployeDto updatedEmployee){
        EmployeDto employeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeDto);
    }

    // Build delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmploye(employeeId);
        return ResponseEntity.ok("Emplyee deleted successfully!.");
    }

}
