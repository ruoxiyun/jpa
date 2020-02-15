package com.example.jpa.controller;

import com.example.jpa.entity.User;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取所有用户(JPA)
     */
    @GetMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
    public void  getAllUser () {

        List<User> allUser = userService.getAllUser();

        for (User user : allUser) {
            System.out.println(user);
        }
    }

    /**
     * 获取所有用户(使用原生sql)
     */
    @GetMapping(value = "/userNative", produces = {"application/json;charset=UTF-8"})
    public void  getAllUserNative () {

        List<User> allUser = userService.getAllUserNative();

        for (User user : allUser) {
            System.out.println(user);
        }
    }

    /**
     * 分页
     */
    @GetMapping(value = "/pagedQueryUser", produces = {"application/json;charset=UTF-8"})
    public void pagedQueryUser (@RequestParam(value = "pageNum") Integer pageNum,
                                    @RequestParam(value = "pageLimit") Integer pageLimit) {

        Page<User> allUser = userService.pagedQueryUser(pageNum,pageLimit);

        for (User user : allUser) {
            System.out.println(user);
        }
    }
}

