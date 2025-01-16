package Anjali.ems.repository;

import Anjali.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoy extends JpaRepository<Employee,Long> {
}



