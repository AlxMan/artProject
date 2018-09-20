package com.art.common;

/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/19 16:24
 * @Version 1.0
 */
public class ThisSystemUtil {
    public  static String thisIfBlank(String message,String target){
        if(target == null ||(target=target.trim()).length()==0){
            throw new ThisSystemException(message);
        }
        return target;
    }
    public static String $(String message,String target){
        return thisIfBlank(message,target);
    }
}