package Anjali.ems.service;

import Anjali.ems.dto.EmployeDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService {
    EmployeDto createEmployee(EmployeDto employeDto);


    EmployeDto getEmployeeById(Long employeeId);

    List<EmployeDto> getAllEmployees();

    EmployeDto updateEmployee(Long employeeId, EmployeDto updateemployee);

    void deleteEmploye(Long employeeId);
}
