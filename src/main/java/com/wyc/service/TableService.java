package com.wyc.service;

import com.wyc.entity.TableInfo;
import com.wyc.entity.TableInfoDetail;

import java.util.List;
import java.util.Map;

/**
 * @author haima
 */
public interface TableService {

    /**
     * 查询所有表属性信息
     * @return 表属性信息列表
     */
    List<TableInfo> queryTables();

    /**
     * 查询表具体信息
     * @param table 表名
     * @return 表具体信息
     */
    List<TableInfoDetail> queryTableInfo(String table);

    Integer insertData(List<Map<String, Object>> list, String tableName);
}
