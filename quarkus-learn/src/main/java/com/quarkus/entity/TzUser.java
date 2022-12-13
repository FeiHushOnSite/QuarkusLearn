package com.quarkus.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: quarkus-learn
 * @className: User
 * @description:
 * @author:
 * @create: 2022-12-12 14:44
 * @Version 1.0
 **/
@Table(name = "tz_user")
@Data
public class TzUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String userId;

    private String nackName;

    private String realName;
    
}
