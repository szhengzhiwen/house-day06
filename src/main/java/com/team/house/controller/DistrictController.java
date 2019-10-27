package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zzw
 * @Date： 2019/10/15
 * @Description：
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    //一请求一方法

    /**
     * 分页显示区域信息
     * @param pageUtil
     * @return
     */
    @RequestMapping("getDistrictByPage")
    @ResponseBody
    public Map<String,Object> getDistrictByPage(PageUtil pageUtil){
        //调用业务
        PageInfo<District> pageInfo = districtService.getDistricByPage(pageUtil);
        //封装到map集合
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        //返回map
        return map;
    }

    /**
     * 实现添加
     * @param district
     * @return
     */
    @RequestMapping("addDistrict")
    @ResponseBody
    public Map<String,Object> addDistrict(District district){
        //1. 调用业务
        int flag = districtService.addDistrict(district);
        //2. 使用map封装返回的数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("result",flag);
        //3. 返回
        return map;
    }

    /**
     * 接收由前端传递的区域编号,查询当前记录
     * @param id
     * @return district
     */
    @RequestMapping("getDistrict")
    @ResponseBody
    public District getDistrict(Integer id){
        //1. 调用业务
        District district = districtService.getDistrict(id);
        //2. 返回
        return district;
    }

    /**
     * 实现修改区域
     * @param district
     * @return
     */
    @RequestMapping("upDistrict")
    @ResponseBody
    public Map<String,Object> upDistrict(District district){
        //调用业务
        int flag = districtService.updateDistrict(district);
        //使用map封装返回的数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("result",flag);
        //返回数据
        return map;
    }

    /**
     * 删除区域信息
     * @param id
     * @return
     */
    @RequestMapping("delDistrict")
    @ResponseBody
    public Map<String,Object> delDistrict(Integer id){
        //调用业务
        int flag = districtService.delDistrict(id);
        //使用map封装返回的数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("result",flag);
        //返回map
        return map;
    }

    //批量删除区域  delMoreDistrit?ids=1006&ids=1007  ====>Integer []ids
// delMoreDistrit?ids=1006,1007  ====>String ids
    @RequestMapping("delMoreDistrit")
    @ResponseBody   //{"result":0}
    public Map<String,Object> delMoreDistrit(String ids){
        //将字符串转化为数组  {1006,1007}
        String [] list=ids.split(",");
        Integer [] ary=new Integer[list.length];
        for (int i = 0; i <list.length ; i++) {
            ary[i]=Integer.parseInt(list[i]);
        }
        //调用业务
        int flag=districtService.delMoreDistrict(ary);
        //使用map封装返回的数据
        // return "{\"result\":"+flag+"}";  //手工拼的json
        Map<String,Object> map=new HashMap();
        map.put("result",flag);  //自动将对象转化为json
        return map;
    }
}
