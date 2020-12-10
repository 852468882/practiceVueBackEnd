package com.example.practicevue;

import com.example.practicevue.utils.DateFormatUtil;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @SneakyThrows
    public void t3(){
        Date date = new Date(1514259368);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
        System.out.println(DateFormatUtil.timestamp2calender(Long.valueOf("1514259365")));
        System.out.println(DateFormatUtil.calender2timestamp("2020-12-04 17:00:00"));
    }

    @Test
    public void t4(){

    }
}
