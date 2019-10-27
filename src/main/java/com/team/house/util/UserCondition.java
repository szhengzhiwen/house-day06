package com.team.house.util;

/**
 * @Author: zzw
 * @Date： 2019/10/17
 * @Description：
 * @Version: 1.0
 */
public class UserCondition extends PageUtil {
    //一个条件一个属性
    private String name;
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
