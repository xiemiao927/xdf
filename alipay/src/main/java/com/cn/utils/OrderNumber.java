package com.cn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *生成唯一订单号
 */
public class OrderNumber {

    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }


}
