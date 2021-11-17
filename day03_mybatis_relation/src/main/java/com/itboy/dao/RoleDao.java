package com.itboy.dao;

import com.itboy.domin.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有
     * @return
     */
    List<Role> findAll();
}
