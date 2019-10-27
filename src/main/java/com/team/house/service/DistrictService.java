package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.util.PageUtil;

import java.util.List;

/**
 * @Author: zzw
 * @Date： 2019/10/15
 * @Description：
 * @Version: 1.0
 */
public interface DistrictService {
    /**
     * 查询所有区域支持分页
     * @param pageInfo
     * @return
     */
    PageInfo<District> getDistricByPage(PageUtil pageInfo);

    /**
     * 添加区域
     * @param district
     * @return
     */
    public int addDistrict(District district);

    /**
     * 通过编号获取区域单条记录
     * @param id 编号
     * @return 区域对象
     */
    public District getDistrict(Integer id);

    /**
     * 修改区域信息
     * @param district 区域信息的实体
     * @return 影响的行数
     */
    public int updateDistrict(District district);

    /**
     * 删除区域信息
     * @param id 区域编号
     * @return 影响行数
     */
    public int delDistrict(Integer id);

    /**
     * 批量删除区域
     * @param ids 区域编号数组
     * @return 影响的行数
     */
    public int delMoreDistrict(Integer []ids);

    /**
     * 查询所有区域信息
     * @return
     */
    public List<District> getAllDistrict();
}
