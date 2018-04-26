package com.wyc.service;

import com.wyc.entity.User;

import java.util.List;

/**
 * @author haima
 */
public interface UserService {

    public int save(User user);

    public int saveUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
