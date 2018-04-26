package com.wyc.utils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 本地通用Mapper接口（继承通用Mapper接口）
 * @author haima
 * @param <T>
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T>{
}
