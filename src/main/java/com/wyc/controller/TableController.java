package com.wyc.controller;

import com.wyc.entity.TableInfo;
import com.wyc.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/table")
public class TableController {

    @Autowired
    private TableService tableService;
    @ResponseBody
    @RequestMapping(value = "/all")
    public List<TableInfo> queryTables(){
        return tableService.queryTables();
    }


}
