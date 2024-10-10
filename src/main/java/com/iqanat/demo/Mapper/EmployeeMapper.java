package com.iqanat.demo.Mapper;

import com.iqanat.demo.DTO.EmployeeDTO;
import com.iqanat.demo.Entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEMployeeDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
    }
}
