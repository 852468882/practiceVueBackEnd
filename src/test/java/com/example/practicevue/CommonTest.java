package com.example.practicevue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcy
 * @date 2020/11/9
 */
@SpringBootTest
public class CommonTest {

    @Test
    public void t1(){
        String s = "Goods-index,Goods-tianjia,Category-index,Order-showlist,Brand-index";
        System.out.println(s.replace(" ",""));
    }

    @Test
    public void t2(){
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("1");
        ids.add("1");
        StringBuilder stringBuilder = new StringBuilder();
        ids.forEach(id -> {
            stringBuilder.append(id).append(",");
        });
        ids.remove("1");
        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
    }

    @Test
    public void t3(){
    }
}
