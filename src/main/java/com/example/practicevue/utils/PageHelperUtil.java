package com.example.practicevue.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author zcy
 * @date 2020/10/28
 */
public class PageHelperUtil {
    /**
     * 分页工具
     * @param pageNum   起始页
     * @param pageSize  页面容量
     * @param supplier  即将查询分页的方法
     * @param <T>       实体类型
     * @return 将查询分页之后的结果
     */
    public static <T> PageInfo<T> page(int pageNum, int pageSize, Supplier<List<T>> supplier){
        PageHelper.startPage(pageNum, pageSize == 0 ? 10 : pageSize);
        PageInfo<T> pageInfo = new PageInfo<T>(supplier.get());
        PageHelper.clearPage();
        return pageInfo;
    }
}
