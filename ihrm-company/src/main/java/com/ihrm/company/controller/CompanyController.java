package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 跨域是什么?浏览器从一个域名的网页去请求另一个域名的资源时，域名、端口、协议任一不同，都是跨域
 * 。我们是采用前后端分离进行开发的，因此也是前后端分离部署的，必然会存在跨域问题。
 * 那么如何解决跨域?很简单，只需要在Controller类上添加注解@CrossOrigin
 * 即可!这个注解其实是CORS的实现。 CORS(Cross-Origin Resource Sharing,
 * 跨源资源共享)是W3C出的一个标准，其思想是使用自定义的HTTP头部让浏览器与服务器进行沟通，
 * 从而决定请求或响应是成功，还是失败。因此，要想实现CORS进行跨域，需要服务器进行一些设置，
 * 同时前端也需要做一些配置和分析
 */
@CrossOrigin  //解决跨域问题
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //保存企业
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Result saveCompany(@RequestBody  Company company){
        companyService.saveCompany(company);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新企业
    /**
     * 1.方法
     * 2.请求参数
     * 3.响应
     * @PathVariable 绑定参数
     *
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result updateCompany(@PathVariable(value = "id") String id, @RequestBody Company company){
        company.setId(id);
        companyService.updateCompany(company);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除企业
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteCompany(@PathVariable(value = "id")String id){
        companyService.deleteId(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询企业
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value ="id")String id){
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    //查询全部企业列表
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Result findAll(){
        List<Company> list = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }
}
