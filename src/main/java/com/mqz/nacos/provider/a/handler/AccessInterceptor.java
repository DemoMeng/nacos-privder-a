package com.mqz.nacos.provider.a.handler;

import com.mqz.nacos.provider.a.common.Constants;
import com.mqz.nacos.provider.a.thread.LocalContext;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mqz
 * @description
 * @abount https://github.com/DemoMeng
 * @since 2020/11/10
 */
public class AccessInterceptor implements HandlerInterceptor {


    /**
     * TODO  token过滤
     * 每个模块中需要有个token拦截器，因为所有的请求被网关模块解析了，网关模块主要就是把token解析，解析出来的信息重新拼接到url上，
     * 然后每个模块就从url获取参数，也就是如下： request.getParameter(CommonConstants.COMPANY_ID)
     * 然后再把这些参数放到ThreadLocal中，问：是不是也能放到request中？
     *
     * ThreadLocal：解决的高并发下的问题，本地线程，每个线程独享一个ThreadLocal，但是如果使用不当（没有调用 ThreadLocal.remove的方法），可能出现内存泄漏的情况！
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //维护网关解析的变量到本地线程
        String userId = request.getParameter("GATEWAY_USER_ID");
        if(!StringUtils.isEmpty(userId)){
            LocalContext.add(Constants.GATEWAY_KEY.USER_ID,userId);
        }
        String userName = request.getParameter("GATEWAY_USER_NAME");
        if(!StringUtils.isEmpty(userName)){
            LocalContext.add(Constants.GATEWAY_KEY.USER_NAME,userName);
        }
        //链路追踪维护
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //防止OOM
        LocalContext.remove();
    }
}
