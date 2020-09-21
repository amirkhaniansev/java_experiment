package com.example.users_api;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserRepository repository;

    UserController(final UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<User> getUsers(UserRequest request) {
        if(request.getPage() < 0)
            request.setPage(1);
        
        if(request.getCount() <= 0 || request.getCount() >= 100) 
            request.setCount(20);

        return this.repository
                   .findAllByName(
                       request.getName(), 
                       PageRequest.of(
                           request.getPage(), 
                           request.getCount(),
                           Sort.by("id").ascending()));
    }

    @PostMapping
    User createUser(User user) {
        user.setId(0);

        return this.repository.save(user);
    }
}