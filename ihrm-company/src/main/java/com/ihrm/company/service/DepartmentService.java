package com.ihrm.company.service;

import com.ihrm.domain.company.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * 保存部门
     */
     public void saveDepartment(Department department);

    /**
     * 更新部门
     */
    public void updateDepartment(Department department);

    /**
     * 根据id查询部门
     */
    public Department findBuIdDepartment(String id);

    /**
     * 查询全部部门列表
     */
    public List<Department> findAllDepartment();

    /**
     * 根据id删除部门
     */
    public void deleteByIdDepartment(String id);
}
