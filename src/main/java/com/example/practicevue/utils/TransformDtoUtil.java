package com.example.practicevue.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zcy
 * @date 2020/11/9
 */
public class TransformDtoUtil {

    static Mapper mapper = new DozerBeanMapper();

    public static <D, E> E transform(D t, Class<E> clazz) {
        if (t == null) {
            return null;
        }
        return mapper.map(t, clazz);
    }

    public static <D, E> List<E> transform(List<D> ts, Class<E> clazz) {
        List<E> es = new ArrayList<>();
        if (ts == null) {
            return es;
        }
        for (D d : ts) {
            E e = transform(d, clazz);
            if (e != null) {
                es.add(e);
            }
        }
        return es;
    }
}
