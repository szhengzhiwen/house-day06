package com.team.house.service;

import com.team.house.entity.Street;

import java.util.List;

/**
 * @Author: zzw
 * @Date： 2019/10/21
 * @Description：
 * @Version: 1.0
 */
public interface StreetService {
    List<Street> getStreetByDistrictId(Integer disstrictId);
}
