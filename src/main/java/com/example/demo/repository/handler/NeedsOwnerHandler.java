package com.example.demo.repository.handler;

import com.example.demo.model.HasUserName;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by song on 2017/11/8.
 */
@Component
@RepositoryEventHandler(HasUserName.class)
public class NeedsOwnerHandler {
    @HandleBeforeCreate
    public void handlePurchaseRecordSave(HasUserName p) {
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
        p.setUsername(username);
    }
}
