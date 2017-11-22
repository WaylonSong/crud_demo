package com.example.demo.model.projection;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by song on 2017/10/30.
 */

@Projection(name = "fullName", types = { Person.class })
public interface FullName {
    @Value("#{target.firstName} #{target.lastName}")
    String getFullName();
}