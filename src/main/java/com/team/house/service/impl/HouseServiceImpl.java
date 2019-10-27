package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date： 2019/10/21
 * @Description：
 * @Version: 1.0
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    public int addHouse(House house){
        return houseMapper.insertSelective(house);
    }

    public List<House> getHouseByUserid(Integer uid) {
        return houseMapper.getHouseByUser(uid);
    }

    public House getHouseById(String id) {
        House house = houseMapper.getHouseById(id);
        return house;
    }

    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public int delHouse(String id, Integer state) {
        //创建实体
        House house = new House();
        //设置房屋编号
        house.setId(id);
        //设置删除的状态
        house.setIsdel(state);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public PageInfo<House> getHouseByPassSate(Integer state, PageUtil pageUtil) {
        //1. 开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //2. 查询所有
        List<House> list=houseMapper.getHouseByPassState(state);
        //3. 返回数据
        return new PageInfo<House>(list);
    }

    public int updateHousePassState(String id, Integer state) {
        House house = new House();
        house.setId(id);//编号
        house.setIspass(state);//审核状态
        return houseMapper.updateByPrimaryKeySelective(house);
    }
}
