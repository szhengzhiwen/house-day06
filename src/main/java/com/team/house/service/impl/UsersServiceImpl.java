package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.UsersService;
import com.team.house.util.MD5Utils;
import com.team.house.util.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * @Author: zzw
 * @Date： 2019/10/17
 * @Description：
 * @Version: 1.0
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    public PageInfo<Users> getUserByCondition(UserCondition userCondition) {
        //1. 开启分页
        PageHelper.startPage(userCondition.getPage(),userCondition.getRows());
        //2. 查询所有用户
        UsersExample usersExample = new UsersExample();
        //3. 使用Criteria封装查询条件
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //添加条件
        if (userCondition.getName()!=null){
            criteria.andNameLike("%"+userCondition.getName()+"%");
        }
        if (userCondition.getTelephone()!=null){
            criteria.andTelephoneLike("%"+userCondition.getTelephone()+"%");
        }
        List<Users> list = this.usersMapper.selectByExample(usersExample);
        return new PageInfo<Users>(list);
    }

    public int addUser(Users users) {
        //使用md5工具类对密码加密码
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        //设置isadmin默认为0
        users.setIsadmin(0);
        return usersMapper.insertSelective(users);
    }

    public int checkUserName(String name) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria= usersExample.createCriteria();
        //用户名条件
        criteria.andNameEqualTo(name);
        //执行
        List<Users> list=usersMapper.selectByExample(usersExample);
        return list.size();
    }

    public Users login(String name, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria= usersExample.createCriteria();
        //用户名和密码条件
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        //执行
        List<Users> list=usersMapper.selectByExample(usersExample);
        if(list.size()==0)
            return null;
        else
            return list.get(0);
    }
}
