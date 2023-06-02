package com.dailyCode.spring_boot_1.service;

import com.dailyCode.spring_boot_1.entity.Department;
import com.dailyCode.spring_boot_1.error.DeptNotFoundException;

import java.util.List;

public interface DepartmentService {
   public  Department saveDepartment(Department department);

   public List<Department> fetchDeptList();

   public Department fetchDeptById(Long deptId) throws DeptNotFoundException;

    public void deleteDeptById(Long deptId);

    public Department updateDept(Long deptId, Department department);

    public Department fetchDeptByName(String deptName);
}
