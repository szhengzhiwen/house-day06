package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.util.PageUtil;
import com.team.house.util.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class UsersController {
    @Autowired
    private UsersService usersService;
    //一请求一方法

    /**
     * 分页显示区域信息
     * @param
     * @return
     */
    @RequestMapping("getUsersByPage")
    @ResponseBody
    public Map<String,Object> getUsersByPage(UserCondition condition){
        //调用业务
        PageInfo<Users> pageInfo = usersService.getUserByCondition(condition);
        //封装到map集合
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        //返回map
        return map;
    }
}
