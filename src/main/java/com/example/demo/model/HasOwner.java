package com.example.demo.model;

import com.example.demo.security.SysUser;

/**
 * Created by song on 2017/11/22.
 */
public interface HasOwner {
    SysUser getOwner();
    void setOwner(SysUser sysUser);
}
