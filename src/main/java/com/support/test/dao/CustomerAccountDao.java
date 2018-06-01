package com.support.test.dao;

import com.support.test.model.CustomerAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountDao extends JpaRepository<CustomerAccount,Integer> {

    Page<CustomerAccount> findCustomAccountsByCustom_Id(Integer id, Pageable pageable);


}
