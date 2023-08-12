package com.prajjwal.rest.webservices.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import com.prajjwal.rest.webservices.restfulwebservices.models.User;
import com.prajjwal.rest.webservices.restfulwebservices.models.UserNotFoundException;
import com.prajjwal.rest.webservices.restfulwebservices.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SocialMediaController {
    @Autowired
    UserDaoService service;
    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) throws Throwable {
        User user = service.getThisUser(id);
        if (user == null)
             throw new UserNotFoundException("user not found");
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        service.addThisUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
