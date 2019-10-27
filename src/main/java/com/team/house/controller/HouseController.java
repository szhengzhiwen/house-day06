package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zzw
 * @Date： 2019/10/25
 * @Description：
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("getHouseNoPass")  //eastui datagrid自动传page,rows
    @ResponseBody
    public Map<String,Object> getHouseNoPass(PageUtil page){
        //调用业务    0表示未审核 1,表示已审核
        PageInfo<House> house=this.houseService.getHouseByPassSate(0,page);
        //返回数据
        Map<String,Object> map=new HashMap();
        map.put("rows",house.getList());
        map.put("total",house.getTotal());
        return map;
    }

    @RequestMapping("goHousePass")
    @ResponseBody
    public String goHousePass(String id){
        //调用业务审核 1表示通过审核
        int temp=this.houseService.updateHousePassState(id,1);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("getHousePass")  //eastui datagrid自动传page,rows
    @ResponseBody
    public Map<String,Object> getHousePass(PageUtil page){
        //调用业务    0表示未审核 1,表示已审核
        PageInfo<House> house=this.houseService.getHouseByPassSate(1,page);
        //返回数据
        Map<String,Object> map=new HashMap();
        map.put("rows",house.getList());
        map.put("total",house.getTotal());
        return map;
    }

    @RequestMapping("goHouseNotPass")
    @ResponseBody
    public String goHouseNotPass(String id){
        //调用业务审核 1表示通过审核
        int temp=this.houseService.updateHousePassState(id,0);
        return "{\"result\":"+temp+"}";
    }
}

