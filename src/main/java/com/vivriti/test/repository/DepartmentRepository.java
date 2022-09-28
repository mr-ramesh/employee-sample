package com.vivriti.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivriti.test.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<Department> findByDepartmentName(String departmentName);

}
