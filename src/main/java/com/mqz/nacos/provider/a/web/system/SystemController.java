package com.mqz.nacos.provider.a.web.system;

import com.mqz.mars.base.response.ResponseBean;
import com.mqz.mars.base.thread.LocalContext;
import com.mqz.nacos.provider.a.common.WebRequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 青网科技集团 版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021/7/7 9:53 上午
 * @Description
 * @About： https://github.com/DemoMeng
 */
@RestController
@RequestMapping(value = WebRequestMapping.PREFIX + "/system")
@Api(tags = "系统设置-系统功能入口",value = "系统设置-系统功能")
@Slf4j
public class SystemController {


    @ApiOperation(value = "获取LocalContext的维护变量")
    @PostMapping(value = "/menu")
    public ResponseBean menu(){
        log.info("获取LocalContext的维护变量请求。。。。。");
        String userId = LocalContext.get("USER_ID",String.class);
        log.info("获取出来的userid：{}",userId);;
        return ResponseBean.SUCCESS();
    }


}
