package Anjali.ems.mapper;

import Anjali.ems.dto.EmployeDto;
import Anjali.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeDto mapToEmployeeDto(Employee employee ){
        return new EmployeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeDto employeDto){
        return new Employee(
                employeDto.getId(),
                employeDto.getFirstName(),
                employeDto.getLastName(),
                employeDto.getEmail()
        );
    }
}
