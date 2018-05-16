package com.wyc.mapper;

import com.wyc.entity.TableInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haima
 */
@Repository
public interface TableMapperCustom {

    List<TableInfo> queryTables();
}
