package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date： 2019/10/15
 * @Description：
 * @Version: 1.0
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 实现分页显示区域信息
     * @param pageInfo
     * @return
     */
    public PageInfo<Type> getDistricByPage(PageUtil pageInfo) {
        //1. 开启分页
        PageHelper.startPage(pageInfo.getPage(),pageInfo.getRows());
        //2. 调用方法
        TypeExample TypeExample = new TypeExample();
        List<Type> list = typeMapper.selectByExample(TypeExample);
        //3. 获取分页信息
        PageInfo<Type> pageInfo1 = new PageInfo<Type>(list);
        //4. 返回
        return pageInfo1;
    }

    /**
     * 实现添加
     * @param Type
     * @return
     */
    public int addType(Type Type) {
        return typeMapper.insertSelective(Type);
    }

    /**
     *通过编号获取区域单条记录
     * @param id
     * @return
     */
    public Type getType(Integer id) {
        //调用dao层
        return typeMapper.selectByPrimaryKey(id);
    }

    public int updateType(Type Type) {
        return typeMapper.updateByPrimaryKeySelective(Type);
    }

    //@Transactional(propagation = Propagation.REQUIRED)
    public int delType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    public int delMoreType(Integer[] ids) {
        return typeMapper.deleteMoreType(ids);
    }

    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }

}
