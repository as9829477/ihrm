package com.ihrm.company.service;


import com.ihrm.domain.company.Company;

import java.util.List;

public interface CompanyService {

    /**
     * 保存企业
     *  1.配置idwork到工程
     *  2.在service中注入idwork
     *  3.通过idwork生成id
     *  4.保存企业
     */
    public void saveCompany(Company company);

    /**
     * 更新企业
     *  1.参数：Company
     *  2.根据id查询企业对象
     *  3.设置修改的属性
     *  4.调用dao完成更新
     */
    public  void updateCompany(Company company);
    /**
     * 根据id查询企业
     */
    public Company findById(String id);
    /**
     * 删除企业
     */

    public void deleteId(String id);

    /**
     * 查询企业列表
     */
    public List<Company> findAll();
}
