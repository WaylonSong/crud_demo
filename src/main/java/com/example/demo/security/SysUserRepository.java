package com.example.demo.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by song on 2017/9/26.
 */
@Repository
public interface SysUserRepository extends CrudRepository<SysUser, Long>{
    public List<SysUser> findByUsername(String username);
}
