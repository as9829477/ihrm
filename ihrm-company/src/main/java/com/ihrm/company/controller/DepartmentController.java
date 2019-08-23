package com.ihrm.company.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.DeptListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/company/department/")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    /**
     * 保存部门信息
     * @param department
     * @return
     */
    @RequestMapping(value = "/saveDepartment",method = RequestMethod.POST)
    public Result saveDepartment(@RequestBody Department department ){
        //保存
        department.setCompanyId(companyId);
        departmentService.saveDepartment(department);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 查询部门信息
     * @return
     */
    @RequestMapping(value = "/findAllDepartment",method = RequestMethod.POST)
    public Result findAllDepartment(){
        //设置保存企业id 先固定值1
        Company company = companyService.findById(companyId);
        //保存
        List<Department> list = departmentService.findAllDepartment(companyId);

        DeptListResult deptListResult  = new DeptListResult(company,list);

        return  new Result(ResultCode.SUCCESS,deptListResult) ;
    }

    /**
     * 根据id查询部门信息
     * @return
     */
    @RequestMapping(value = "findByIdDepartment/{id}",method = RequestMethod.GET)
    public Result findByIdDepartment(@PathVariable(value = "id") String id){

        Department buIdDepartment = departmentService.findBuIdDepartment(id);

        return  new Result(ResultCode.SUCCESS,buIdDepartment) ;
    }

    /**
     * 根据id修改部门信息
     * @return
     */
    @RequestMapping(value = "updateByIdDepartment/{id}",method = RequestMethod.PUT)
    public Result updateByIdDepartment(@PathVariable(value = "id") String id,@RequestBody Department department){

        department.setId(id);
        departmentService.updateDepartment(department);

        return  new Result(ResultCode.SUCCESS) ;
    }

    /**
     * 根据id查询部门信息
     * @return
     */
    @RequestMapping(value = "deleteByIdDepartment/{id}",method = RequestMethod.DELETE)
    public Result deleteByIdDepartment(@PathVariable(value = "id") String id){

         departmentService.deleteByIdDepartment(id);

         return  new Result(ResultCode.SUCCESS) ;
    }
}
