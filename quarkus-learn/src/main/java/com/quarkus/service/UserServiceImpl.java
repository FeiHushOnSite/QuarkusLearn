package com.quarkus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quarkus.dao.UserMapper;
import com.quarkus.entity.TzUser;
import io.quarkus.panache.common.Page;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @program: quarkus-learn
 * @className: UserServiceImpl
 * @description:
 * @author:
 * @create: 2022-12-12 17:08
 * @Version 1.0
 **/
@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserMapper userMapper;


    @Override
    public List<TzUser> getUser(int index) {
        Page page = new Page(index, 10);
        Wrapper<TzUser> query = new QueryWrapper<>();
        return userMapper.selectList(query);
    }
}
