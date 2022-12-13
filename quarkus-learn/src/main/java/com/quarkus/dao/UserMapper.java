package com.quarkus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quarkus.entity.TzUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: quarkus-learn
 * @className: UserRepository
 * @description:
 * @author:
 * @create: 2022-12-12 14:58
 * @Version 1.0
 **/

@Mapper
public interface UserMapper extends BaseMapper<TzUser> {
}
