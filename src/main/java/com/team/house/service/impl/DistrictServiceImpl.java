package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.service.DistrictService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zzw
 * @Date： 2019/10/15
 * @Description：
 * @Version: 1.0
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    /**
     * 实现分页显示区域信息
     * @param pageInfo
     * @return
     */
    public PageInfo<District> getDistricByPage(PageUtil pageInfo) {
        //1. 开启分页
        PageHelper.startPage(pageInfo.getPage(),pageInfo.getRows());
        //2. 调用方法
        DistrictExample districtExample = new DistrictExample();
        List<District> list = districtMapper.selectByExample(districtExample);
        //3. 获取分页信息
        PageInfo<District> pageInfo1 = new PageInfo<District>(list);
        //4. 返回
        return pageInfo1;
    }

    /**
     * 实现添加
     * @param district
     * @return
     */
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    /**
     *通过编号获取区域单条记录
     * @param id
     * @return
     */
    public District getDistrict(Integer id) {
        //调用dao层
        return districtMapper.selectByPrimaryKey(id);
    }

    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    //@Transactional(propagation = Propagation.REQUIRED)
    public int delDistrict(Integer id) {
        //1.通过区域编号删除街道
        districtMapper.deleteStreetByDistrict(id);
        //2. 删除区域
        districtMapper.deleteByPrimaryKey(id);
        return 1;
    }

    public int delMoreDistrict(Integer[] ids) {
        return districtMapper.deleteMoreDistrict(ids);
    }

    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }

}
