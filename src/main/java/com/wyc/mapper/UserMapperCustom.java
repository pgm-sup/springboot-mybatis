package com.wyc.mapper;

import com.wyc.entity.User;
import com.wyc.utils.TkMapper;
import org.springframework.stereotype.Repository;

/**
 * 自定义mapper，一些复杂sql或者复杂操作
 * @author haima
 */
@Repository
public interface UserMapperCustom {

    public int saveUser(User user);
}