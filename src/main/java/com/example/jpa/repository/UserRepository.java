package com.example.jpa.repository;

import com.example.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {//为啥我们传入<User, String>,看一下源码就能了解
    //在JPA中也能执行原生的SQL，具体参考https://blog.csdn.net/lovequanquqn/article/details/83501121
    @Query(value = "select * from users",nativeQuery = true)
    List<User> findAllNative();
}
