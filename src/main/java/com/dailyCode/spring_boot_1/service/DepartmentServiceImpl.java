package com.dailyCode.spring_boot_1.service;

import com.dailyCode.spring_boot_1.entity.Department;
import com.dailyCode.spring_boot_1.error.DeptNotFoundException;
import com.dailyCode.spring_boot_1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository depRepo;

    @Override
    public Department saveDepartment(Department department) {
        return depRepo.save(department);

    }
    @Override
    public List<Department> fetchDeptList() {
        return depRepo.findAll();
    }

    @Override
    public Department fetchDeptById(Long deptId) throws DeptNotFoundException {

        Optional<Department> department = depRepo.findById(deptId);
        if(!department.isPresent()){
            throw new DeptNotFoundException("Department not found");
        }
        return department.get();

    }

    @Override
    public void deleteDeptById(Long deptId) {
        depRepo.deleteById(deptId);
    }

    @Override
    public Department updateDept(Long deptId, Department department) {
        Department dept = depRepo.findById(deptId).get();

        if(Objects.nonNull(department.getDepAdd()) && !"".equalsIgnoreCase(department.getDepAdd())){
            dept.setDepAdd(department.getDepAdd());
        }

        if(Objects.nonNull(department.getDepCode()) && !"".equalsIgnoreCase(department.getDepCode())){
            dept.setDepCode(department.getDepCode());
        }

        if(Objects.nonNull(department.getDepName()) && !"".equalsIgnoreCase(department.getDepName())){
            dept.setDepName(department.getDepName());
        }

        return depRepo.save(dept);
    }

    @Override
    public Department fetchDeptByName(String deptName) {
        return depRepo.findByDepNameIgnoreCase(deptName);
    }


}
