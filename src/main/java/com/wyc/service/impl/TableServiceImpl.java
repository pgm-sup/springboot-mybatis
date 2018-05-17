package com.wyc.service.impl;

import com.wyc.entity.TableInfo;
import com.wyc.entity.TableInfoDetail;
import com.wyc.mapper.TableMapperCustom;
import com.wyc.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haima
 */
@Service
public class TableServiceImpl implements TableService{

    @Autowired
    private TableMapperCustom tableMapperCustom;

    @Override
    public List<TableInfo> queryTables(){
        return tableMapperCustom.queryTables();
    }

    @Override
    public List<TableInfoDetail> queryTableInfo(String table) {
        return tableMapperCustom.queryTableInfo(table);
    }

    @Override
    public Integer insertData(List<Map<String, Object>> list, String tableName) {
        int i = 0;
        for (Map<String, Object> pd : list) {
            i += tableMapperCustom.insertData(pd, tableName);
        }
        return i;
    }
}
