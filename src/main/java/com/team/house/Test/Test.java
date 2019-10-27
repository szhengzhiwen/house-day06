package com.team.house.Test;

import com.team.house.service.impl.DistrictServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zzw
 * @Date： 2019/10/17
 * @Description：
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        DistrictServiceImpl districtService=(DistrictServiceImpl)ctx.getBean("districtServiceImpl");
        districtService.delDistrict(1022);
        System.out.println("成功");
    }
}
