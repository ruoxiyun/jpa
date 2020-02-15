package com.example.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity // jpa的注解，需要加
@Table(name = "users") // 指定数据库的表名
@Data // lombok
public class User {

	/*
	主键生成策略
	TABLE：使用一个特定的数据库表格来保存主键。
	SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
	IDENTITY：主键由数据库自动生成（主要是自动增长型）
	AUTO：主键由程序控制。
	*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="userID")
    private Integer userId;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;
}
