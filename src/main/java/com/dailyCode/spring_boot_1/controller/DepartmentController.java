package com.dailyCode.spring_boot_1.controller;

import com.dailyCode.spring_boot_1.entity.Department;
import com.dailyCode.spring_boot_1.error.DeptNotFoundException;
import com.dailyCode.spring_boot_1.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService depService;

    private final Logger logger =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
         logger.info("Inside saveDept");
        return depService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDeptList(){
        logger.info("Inside fetchDept");
        return depService.fetchDeptList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDeptById(@PathVariable("id") Long deptId) throws DeptNotFoundException {

        return depService.fetchDeptById(deptId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDeptByid(@PathVariable("id") Long deptId){
        depService.deleteDeptById(deptId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long deptId,@RequestBody Department department){
        return depService.updateDept(deptId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDeptByName(@PathVariable("name") String deptName){
        return depService.fetchDeptByName(deptName);
    }
}
