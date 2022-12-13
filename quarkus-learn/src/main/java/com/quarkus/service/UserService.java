package com.quarkus.service;

import com.quarkus.entity.TzUser;

import java.util.List;

/**
 * @program: quarkus-learn
 * @interfaceName: UserService
 * @description:
 * @author:
 * @create: 2022-12-12 15:21
 * @Version 1.0
 **/
public interface UserService {

    List<TzUser> getUser(int index);

}
