package com.example.demo.model.projection;

import com.example.demo.model.Gender;
import com.example.demo.model.Person;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by song on 2017/10/30.
 */
@Projection(name = "noEmail", types = { Person.class })
interface NoEmail {
//http://127.0.0.1:8083/api/persons?projection=noEmail
    String getFirstName();

    String getLastName();

    Gender getGender();

}