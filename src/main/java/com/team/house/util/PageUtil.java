package com.team.house.util;

/**
 * @Author: zzw
 * @Date： 2019/10/14
 * @Description：分页的工具类
 * @Version: 1.0
 */
public class PageUtil {
    private Integer page;//接收页码
    private Integer rows;//页大小

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
