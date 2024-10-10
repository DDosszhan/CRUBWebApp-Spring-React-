package com.iqanat.demo.Service.impl;

import com.iqanat.demo.DTO.EmployeeDTO;
import com.iqanat.demo.Entity.Employee;
import com.iqanat.demo.Exception.ResourceNotFoundException;
import com.iqanat.demo.Mapper.EmployeeMapper;
import com.iqanat.demo.Repository.EmployeeRepository;
import com.iqanat.demo.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id "+employeeId+" does not exist"));
        return EmployeeMapper.mapToEMployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(EmployeeMapper::mapToEMployeeDTO).collect(Collectors.toList());
    }
}
