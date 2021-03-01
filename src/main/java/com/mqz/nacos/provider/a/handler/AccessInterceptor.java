package com.mqz.nacos.provider.a.handler;

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
     * token过滤
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if(handler instanceof HandlerMethod){
            String userId = request.getParameter("GATEWAY_USER_ID");
            if(StringUtils.isEmpty(userId)){
                returnJson(response,"{\"code\":403,\"msg\":\"禁止直接访问服务\"}");
                return false;
            }
//            String token = request.getHeader("token");
//            if(StringUtils.isEmpty(token)){
//                returnJson(response,"{\"code\":433,\"msg\":\"token为空\"}");
//                //throw new BusinessException(ResponseEnum.WITHOUT_TOKEN);
//                return false;
//            }
//                String jwtKey = CommonConstants.Admin.System.USER_JWT_+token;
//                String jwt = (String) RedisService.get(jwtKey);
//                if(StringUtils.isEmpty(jwt)){
//                    //returnJson(response,"{\"code\":434,\"msg\":\"token不存在\"}");
//                    //throw new BusinessException(ResponseEnum.TOKEN_NOT_EXIST);
//                    //return false;
//                }
            return true;
        }
        return true;
    }

    /**
     * 返回json
     * @param response
     * @param json
     */
    private void returnJson(HttpServletResponse response, String json){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }
}
