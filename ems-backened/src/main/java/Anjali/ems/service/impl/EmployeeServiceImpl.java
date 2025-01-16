package Anjali.ems.service.impl;

import Anjali.ems.dto.EmployeDto;
import Anjali.ems.entity.Employee;
import Anjali.ems.exception.ResourceNotFoundException;
import Anjali.ems.mapper.EmployeeMapper;

import Anjali.ems.repository.EmployeeRepositoy;
import Anjali.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepositoy employeeRepositoy;

    @Override
    public EmployeDto createEmployee(EmployeDto employeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeDto);
        Employee savedEmployee =  employeeRepositoy.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepositoy.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee doesn't exist with the given id" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeDto> getAllEmployees() {
        List<Employee> employees=employeeRepositoy.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee)).
                collect(Collectors.toList());
    }

    @Override
    public EmployeDto updateEmployee(Long employeeId, EmployeDto updateemployee) {

        Employee employee = employeeRepositoy.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee doesn't exist "+employeeId));

        employee.setFirstName(updateemployee.getFirstName());
        employee.setLastName(updateemployee.getLastName());
        employee.setEmail(updateemployee.getEmail());

        Employee updatedEmployeeObj =  employeeRepositoy.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmploye(Long employeeId) {
        Employee employee = employeeRepositoy.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee doesn't exist "+employeeId));

        employeeRepositoy.deleteById(employeeId);
    }
}
