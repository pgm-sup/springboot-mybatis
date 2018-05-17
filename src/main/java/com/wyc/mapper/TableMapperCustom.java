package com.wyc.mapper;

import com.wyc.entity.TableInfo;
import com.wyc.entity.TableInfoDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author haima
 */
@Repository
public interface TableMapperCustom {

    /**
     * 查询所有表信息
     * @return 所有表信息
     */
    List<TableInfo> queryTables();


    /**
     * 查询单个表具体信息
     * @param table 表名
     * @return 表具体信息
     */
    List<TableInfoDetail> queryTableInfo(String table);

    int insertData(@Param("params")Map<String, Object> params, @Param("tableName")String tableName);
}
