package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.util.PageUtil;

import java.util.List;

/**
 * @Author: zzw
 * @Date： 2019/10/15
 * @Description：
 * @Version: 1.0
 */
public interface TypeService {
    /**
     * 查询所有区域支持分页
     * @param pageInfo
     * @return
     */
    PageInfo<Type> getDistricByPage(PageUtil pageInfo);

    /**
     * 添加区域
     * @param Type
     * @return
     */
    public int addType(Type Type);

    /**
     * 通过编号获取区域单条记录
     * @param id 编号
     * @return 区域对象
     */
    public Type getType(Integer id);

    /**
     * 修改区域信息
     * @param Type 区域信息的实体
     * @return 影响的行数
     */
    public int updateType(Type Type);

    /**
     * 删除区域信息
     * @param id 区域编号
     * @return 影响行数
     */
    public int delType(Integer id);

    /**
     * 批量删除区域
     * @param ids 区域编号数组
     * @return 影响的行数
     */
    public int delMoreType(Integer[] ids);

    /**
     * 查询所有类型信息
     * @return
     */
    public List<Type> getAllType();
}
