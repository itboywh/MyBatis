package com.itboy.dao;

import com.itboy.domin.Account;
import com.itboy.domin.AccountUser;

import java.util.List;

public interface IAccountDao  {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();
    List<AccountUser> findAllAccount();
}
