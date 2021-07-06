package com.mqz.nacos.provider.a.web.user;

import com.mqz.mars.base.jwt.JwtTools;
import com.mqz.mars.base.response.ResponseBean;
import com.mqz.mars.base.utils.UuidUtils;
import com.mqz.nacos.provider.a.common.WebRequestMapping;
import com.mqz.nacos.provider.a.common.dtos.UserLoginDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021/7/6 2:46 下午
 * @Description
 * @About： https://github.com/DemoMeng
 */
@RestController
@RequestMapping(value = WebRequestMapping.PREFIX+"/user/account")
@Api(tags = "用户系统-账号功能控制入口",value = "用户系统-账号功能")
@Slf4j
public class AccountController {


    @PostMapping(value = "/login")
    public ResponseBean login(@RequestBody UserLoginDTO dto){
        log.info("请求DTO：{}",dto.toString());
        log.info("密码登陆");
        //随机uuid作为jwt的唯一标识
        String frontToken = UuidUtils.getUuid();

        //模拟角色及其他信息
        List<String> roleIdList = new ArrayList<String>(){
            {
                add("1");
                add("2");
                add("999");
            }
        };
        //模拟用户ID
        Random random = new Random();
        String userId = String.valueOf(random.nextInt(100));

        String jwtResult = JwtTools.getJwt(frontToken,userId,null);


        Map<String,Object> result = new HashMap<>();
        result.put("frontToken",frontToken);
        result.put("jwt",jwtResult);

        //NOSQL记录登陆信息
//        RedisService.set(CommonConstants.Current.CURRENT_USER_TOKEN+simpleSystemUser.getId(),frontToken,tokenExpireTime);
//        RedisService.set(frontToken,jwtResult,tokenExpireTime);

        return ResponseBean.SUCCESS(result);
    }


}
