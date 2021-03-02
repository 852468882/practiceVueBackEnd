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
     * @param supplier  即将查询的方法
     * @param <T>       查询返回的实体类型
     * @return 将查询结果分页之后的数据
     */
    public static <T> PageInfo<T> page(int pageNum, int pageSize, Supplier<List<T>> supplier){
        PageHelper.startPage(pageNum, pageSize == 0 ? 10 : pageSize);
        PageInfo<T> pageInfo = new PageInfo<>(supplier.get());
        PageHelper.clearPage();
        return pageInfo;
    }
}
