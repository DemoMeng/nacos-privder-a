package com.mqz.nacos.provider.a.web;

import com.mqz.nacos.feign.api.FeignApi;
import com.mqz.nacos.feign.common.Bean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021/9/2 2:21 下午
 * @Description
 * @About： https://github.com/DemoMeng
 */

@Api(tags = "服务方-feign公共接口-继承性")
@Slf4j
@RestController
@RequestMapping("")
public class FeignApiController implements FeignApi {

    @Override
    @ApiOperation(value = "服务方-1")
    public String api1(String para) {
        long start = new Date().getTime();
        log.info("【openfeign继承性1】请求成功provider，请求参数：{}",para);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long costTime = new Date().getTime() - start;
        log.info("【openfeign继承性1】请求成功provider，耗时：{}",costTime);
        return "provider返回1";
    }

    @Override
    @ApiOperation(value = "服务方-2")
    public String api2(Bean bean) {
        log.info("【openfeign继承性2】请求成功provider，请求参数：{}",bean.toString());
        return "provider返回2";
    }
}
