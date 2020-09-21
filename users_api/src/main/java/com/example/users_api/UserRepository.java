package com.example.users_api;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.users_api.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    List<User> findAllByName(String name, Pageable pageable);
}