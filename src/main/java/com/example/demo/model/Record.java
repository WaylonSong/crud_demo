package com.example.demo.model;

import com.example.demo.security.SysUser;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by song on 2017/10/30.
 */
//ManyToOne Demo

@Entity
@Data
public class Record implements HasOwner{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    SysUser owner;
    String description;
}
