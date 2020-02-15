package com.example.jpa.service;

import com.example.jpa.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    List<User> getAllUserNative();

    Page<User> pagedQueryUser(Integer pageNum, Integer pageLimit);
}
