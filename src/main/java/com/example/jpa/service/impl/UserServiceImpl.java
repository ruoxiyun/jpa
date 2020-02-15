package com.example.jpa.service.impl;

import com.example.jpa.entity.User;
import com.example.jpa.repository.UserRepository;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ruoxiyun
 * @Date: 2020/2/15 21:54
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll(); //为啥会有findAll()方法？因为我们的UserRepository 继承了JpaRepository
    }

    @Override
    public List<User> getAllUserNative() {
        return userRepository.findAllNative();
    }

    @Override
    public Page<User> pagedQueryUser(Integer pageNum, Integer pageLimit) {
        //sort日后可以配活，按照哪个字段升序还是降序
        Sort sort = Sort.by(Sort.Order.desc("userId"));
        Pageable pageable = PageRequest.of(pageNum - 1, pageLimit, sort);
        return userRepository.findAll(pageable);
    }
}
