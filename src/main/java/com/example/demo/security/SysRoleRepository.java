package com.example.demo.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by song on 2017/9/26.
 */
@Repository
public interface SysRoleRepository extends CrudRepository<SysRole, Long> {
}
