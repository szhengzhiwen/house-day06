package com.team.house.service.impl;

import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.StreetService;
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
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;
    public List<Street> getStreetByDistrictId(Integer disstrictId) {
        StreetExample streetExample=new StreetExample();
        //添加查询条件
        StreetExample.Criteria criteria=streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(disstrictId);
        List<Street> list= streetMapper.selectByExample(streetExample);
        return list;
    }
}
