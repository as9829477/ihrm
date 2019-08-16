package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保持企业
     */
    public void saveCompany(Company company){
        String id= idWorker.nextId()+"";
        company.setId(id);
        company.setAuditState("1");
        company.setState(1);
        companyDao.save(company);
    }

    /**
     * 更新企业
     */
    public  void updateCompany(Company company){
        Company company1 = companyDao.findById(company.getId()).get();
        company1.setName("青年");

    }
    /**
     * 根据id查询企业
     */

    /**
     * 删除企业
     */

    /**
     * 查询企业列表
     */

}
