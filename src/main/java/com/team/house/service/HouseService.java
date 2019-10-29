package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.util.HouseCondition;
import com.team.house.util.PageUtil;

import java.util.List;

/**
 * @Author: zzw
 * @Date： 2019/10/21
 * @Description：
 * @Version: 1.0
 */
public interface HouseService {

    /**
     * 发布出租房
     *
     * @param house 实体
     * @return 影响的行数
     */
    public int addHouse(House house);

    /**
     * 查询用户的出租房信息
     *
     * @param uid 用户编号
     * @return 出租房信息
     */
    public List<House> getHouseByUserid(Integer uid);

    /**
     * 查询某条出租房信息
     *
     * @param id 出租房编号
     * @return 出租房的实体
     */
    public House getHouseById(String id);

    /**
     * 修改出租房
     *
     * @param house
     * @return 影响行数
     */
    public int updateHouse(House house);

    /**
     * 删除出租房
     *
     * @param id    房屋编号
     * @param state 如果状态为1表示删除,为0 未删除
     * @return 影响的行数
     */
    public int delHouse(String id, Integer state);

    /**
     * 查询已审核|未审核的出租房信息
     *  @param state 状态 0:未审核,1:已审核通过
     *
     * @param pageUtil 分页条件
     * @return 所有的出租房信息
     */
    public PageInfo<House> getHouseByPassSate(Integer state,PageUtil pageUtil);

    /**
     * 修改出租房的审核状态
     * @param id 编号
     * @param state 0 未审核 1 已审核
     * @return 影响行数
     */
    public int updateHousePassState(String id,Integer state);

    /**
     * 查询所有浏览出租房信息
     * @param condition 查询条件 分页page,rows
     * @return
     */
    PageInfo<House> getHouseByBroswer(HouseCondition condition);
}