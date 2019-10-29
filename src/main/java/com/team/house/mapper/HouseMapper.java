package com.team.house.mapper;

import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.util.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //一功能一方法
    List<House> getHouseByUser(Integer userid);

    //查询某条出租房信息
    House getHouseById(String id);

    //查询所有未|已审核的出租房
    List<House> getHouseByPassState(Integer state);

    //实现浏览出租房  分页插件,无需考虑分页
    List<House> getHouseByBroswer(HouseCondition condition);
}