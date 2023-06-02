package com.dailyCode.spring_boot_1.repository;

import com.dailyCode.spring_boot_1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepName(String depName);

    public Department findByDepNameIgnoreCase(String depName);
}

