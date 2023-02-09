package com.newcoder.community.util;

/**
 * @author liuyang
 * @create 2023-02-09 9:06
 */
public interface CommunityConstant {

    /**
     * 激活成功
     */
    int ACTIVATION_SUCCESS = 0;

    /**
     * 重复激活
     */
    int ACTIVATION_REPEAT = 1;

    /**
     * 激活失败
     */
    int ACTIVATION_FAILURE = 2;


    /**
     * 默认状态的登录凭证的超时时间：12个小时
     */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    /**
     * 记住状态的登录凭证超时时间：100天
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;

}
