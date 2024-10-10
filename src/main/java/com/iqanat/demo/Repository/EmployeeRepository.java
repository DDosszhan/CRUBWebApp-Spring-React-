package com.iqanat.demo.Repository;

import com.iqanat.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


// add @Repository when using @Query to create your own methods
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
