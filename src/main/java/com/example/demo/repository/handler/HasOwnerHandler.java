package com.example.demo.repository.handler;

import com.example.demo.model.HasOwner;
import com.example.demo.security.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by song on 2017/11/8.
 */
@Component
@RepositoryEventHandler(HasOwner.class)
public class HasOwnerHandler {
    @Autowired
    SysUserRepository sysUserRepository;

    @HandleBeforeCreate
    public void handleBefore(HasOwner p) {
        // … you can now deal with Person in a type-safe way
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        if (username.equals("anonymousUser")){
            username = "";
        }
        p.setOwner(sysUserRepository.findByUsername(username).get(0));
    }
}
