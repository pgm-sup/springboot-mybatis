package com.wyc.service.impl;

import com.wyc.entity.TableInfo;
import com.wyc.mapper.TableMapperCustom;
import com.wyc.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TableServiceImpl implements TableService{

    @Autowired
    private TableMapperCustom tableMapperCustom;

    public List<TableInfo> queryTables(){
        return tableMapperCustom.queryTables();
    }
}
