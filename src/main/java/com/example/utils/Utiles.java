package com.example.utils;

import android.app.ActivityManager;
import android.content.Context;

import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Utiles {
    public static long getTimestampByDay(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String dateStr = simpleDateFormat.format(d);
        try{
            Date date = simpleDateFormat.parse(dateStr);
            return date.getTime();

        }catch (ParseException e){
            e.printStackTrace();
        }
        return 0L;
    }

    public static double getDistanceVal(int stepCount){
        //步长
        int stepLen = 50;
        double distance = (stepCount*(long)(stepLen))/100000.0f;
        return distance;
    }


    //将对象转换成字符串
    public static String objToJson(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static String getFormatVal(double val,String formatString){
        DecimalFormat decimalFormat = new DecimalFormat(formatString);
        return decimalFormat.format(val);
    }

    public static String getFormatVal(double val){
//        DecimalFormat doubleecimalFormat = new DecimalFormat("0.00");
        return getFormatVal(val,"0.00");
    }
    /**
    *服务是否运行
     * 判断服务是否在运行
    *@author Fan Xin <fanxin.hit@gmail.com>
    *@time
    */
    public static boolean isServiceRunning(Context context, String serviceName){
        boolean isRunning = false;
        if (context==null||serviceName==null){
            return isRunning;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List serviceList = activityManager.getRunningServices(Integer.MAX_VALUE);
        Iterator iterator = serviceList.iterator();
        while (iterator.hasNext()){
            ActivityManager.RunningServiceInfo runningServiceInfo =
                    (ActivityManager.RunningServiceInfo) iterator.next();
            if (serviceName.trim().equals(runningServiceInfo.service.getClassName())){
                isRunning = true;
                return isRunning;
            }
        }
        return isRunning;

    }




}
