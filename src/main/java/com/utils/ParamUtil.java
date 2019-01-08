package com.utils;

import org.springframework.util.StringUtils;

/**
 * 参数工具类
 * @author lizhigang
 */
public class ParamUtil {

    /**
     * 判断传入值是否为空
     * @param param
     * @return 为空则返回true
     */
    public static boolean isEmpty(String... param){
        boolean falg = true;
        for (int i=0;i<param.length;i++) {
            if(StringUtils.isEmpty(param[i])) {
                falg=false;
            }
        }
        return falg;
    }
}
