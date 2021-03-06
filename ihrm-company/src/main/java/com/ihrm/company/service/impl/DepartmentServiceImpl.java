package com.ihrm.company.service.impl;

import com.ihrm.common.service.BaseService;
import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DepartmentServiceImpl extends BaseService implements DepartmentService {

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
    public List<Department> findAllDepartment(String companyId) {

        /**
         * 用户构造查询条件
         *   Root<Department> root    包含了所有对象数据
         *   CriteriaQuery<?> criteriaQuery   一般不用
         *   CriteriaBuilder criteriaBuilder  构造查询条件
         */
//        Specification<Department> spec = new Specification<Department>() {
//            @Override
//            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.equal(root.get("companyId").as(String.class),companyId);
//            }
//        };
        return departmentDao.findAll(getSpec(companyId));
    }

    @Override
    @Transactional
    public void deleteByIdDepartment(String id) {
        departmentDao.deleteById(id);
    }
}
