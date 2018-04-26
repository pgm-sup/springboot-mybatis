package com.wyc.service.impl;

import com.github.pagehelper.PageHelper;
import com.wyc.entity.User;
import com.wyc.mapper.UserMapper;
import com.wyc.mapper.UserMapperCustom;
import com.wyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haima
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Override
    public int save(User user) {
        int num = userMapperCustom.saveUser(user);
        return num;
    }

    @Override
    @Transactional
    public int saveUser(User user) {
        int num = userMapper.insert(user);
        return num;
    }

    @Override
    @Transactional
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAll();
    }
}
