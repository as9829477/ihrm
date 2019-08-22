package com.ihrm.company.service.impl;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    @Transactional
    public void saveDepartment(Department department) {
        String id=idWorker.nextId()+"";
        department.setId(id);
        departmentDao.save(department);
    }

    @Override
    @Transactional
    public void updateDepartment(Department department) {
        Department depart= departmentDao.findById(department.getId()).get();
        depart.setCode(department.getCode());
        depart.setIntroduce(department.getIntroduce());
        depart.setName(department.getName());
        departmentDao.save(depart);
    }

    @Override
    public Department findBuIdDepartment(String id) {
        Department department = departmentDao.findById(id).get();
        return department;
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    @Transactional
    public void deleteByIdDepartment(String id) {
        departmentDao.deleteById(id);
    }
}
