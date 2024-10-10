package com.iqanat.demo.Service.impl;

import com.iqanat.demo.DTO.EmployeeDTO;
import com.iqanat.demo.Entity.Employee;
import com.iqanat.demo.Mapper.EmployeeMapper;
import com.iqanat.demo.Repository.EmployeeRepository;
import com.iqanat.demo.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEMployeeDTO(savedEmployee);
    }
}
