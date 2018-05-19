package com.wyc.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyc.entity.TableInfo;
import com.wyc.service.TableService;
import com.wyc.utils.HaimaJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author haima
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/index")
    public Object index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("form");
        return mv;
    }

    @RequestMapping(value = "/detail")
    public Object detail(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formDetails");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TableInfo> queryTables(Model model){
//        List<TableInfo> tables = tableService.queryTables();
//        model.addAttribute("tables", tables);
        return tableService.queryTables();
    }

    @ResponseBody
    @RequestMapping(value = "/tableDetail", method = RequestMethod.GET)
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
