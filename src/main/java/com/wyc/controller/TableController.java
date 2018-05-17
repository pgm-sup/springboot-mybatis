package com.wyc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyc.entity.TableInfo;
import com.wyc.service.TableService;
import com.wyc.utils.HaimaJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author haima
 */
@Controller
@RequestMapping(value = "/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TableInfo> queryTables(){
        return tableService.queryTables();
    }

    @ResponseBody
    @RequestMapping(value = "/tableDetail", method = RequestMethod.POST)
    public HaimaJSONResult queryTableInfo(@RequestParam(value = "tableName") String table){
        return HaimaJSONResult.ok(tableService.queryTableInfo(table));
    }

    @ResponseBody
    @RequestMapping(value = "/insertData", method = RequestMethod.POST)
    public Integer insertData(HttpServletRequest request){
        JSONObject json= JSONObject.parseObject(request.getParameter("data"));
        String tableName = json.getString("tableName");
        List<Map<String, Object>> list = (List<Map<String, Object>>) json.get("Datas");
        return tableService.insertData(list,tableName);
    }
}
