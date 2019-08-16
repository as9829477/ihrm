package com.ihrm.company.dao;

import com.ihrm.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/** 接口需要继承两个规范接口
 *  JpaRepository<实体类型，主键类型></>
 *  JpaSpecificationExecutor<实体类></>
 *  JpaRepository提供了基本的增删改查 ，JpaSpecificationExecutor用于做复杂的条件查询
 */

public interface CompanyDao extends JpaRepository<Company,String>, JpaSpecificationExecutor<Company> {
}
