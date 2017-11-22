package com.example.demo;

import com.example.demo.repository.RecordRepository;
import com.example.demo.security.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2017/9/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
@SpringBootTest(classes = {CrudDemoApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SysUserRepositoryTest {
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    SysRoleRepository sysRoleRepository;
    @Autowired
    SysUserRepository sysUserRepository;
    @Autowired
    RecordRepository recordRepository;
    @Test
    public void addRoles() throws Exception {
        SysRole sysRole = new SysRole();
        sysRole.setName("ROLE_ADMIN");
        sysRoleRepository.save(sysRole);
        sysRole = new SysRole();
        sysRole.setName("ROLE_USER");
        sysRoleRepository.save(sysRole);
    }
    @Test
    public void createAdminAndUser() throws Exception {
        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("123456");
        List<SysRole> sysRoleList = new ArrayList<>();
        sysRoleList.add(sysRoleRepository.findOne(1L));
        sysRoleList.add(sysRoleRepository.findOne(2L));
        user.setRoles(sysRoleList);
        customUserDetailsService.create(user);
    }

    @Test
    public void createUsers() throws Exception {
        SysUser user = new SysUser();
        user.setUsername("user");
        user.setPassword("123456");
        List<SysRole> sysRoleList = new ArrayList<>();
        sysRoleList.add(sysRoleRepository.findOne(2L));
        user.setRoles(sysRoleList);
        customUserDetailsService.create(user);
    }

    @Test
    public void createRecords() throws Exception {
//        Record record = new Record();
//        record.setId(1L);
//        record.setDescription("1111");
//        record.setOwner((SysUser) customUserDetailsService.loadUserByUsername("swl"));
//        recordRepository.save(record);
//
//        record = new Record();
//        record.setId(2L);
//        record.setDescription("2222");
//        record.setOwner((SysUser) customUserDetailsService.loadUserByUsername("swl2"));
//        recordRepository.save(record);

    }
}