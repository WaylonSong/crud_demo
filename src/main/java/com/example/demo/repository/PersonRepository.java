package com.example.demo.repository;

/**
 * Created by song on 2017/10/23.
 */

import com.example.demo.model.Person;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
//简单例子没有权限管理
@CrossOrigin
@RepositoryRestResource
public interface PersonRepository extends BaseRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);
}