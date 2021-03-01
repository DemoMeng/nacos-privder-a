package com.mqz.nacos.provider.a.web;

import com.mqz.nacos.provider.a.common.WebRequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mqz
 * @description
 * @abount https://github.com/DemoMeng
 * @since 2021/2/24
 */
@RestController
@RequestMapping(WebRequestMapping.PREFIX+"/feign")
@RefreshScope //动态刷新读取Nacos配置文件
public class FeignHttpController {

    private final static Logger log = LoggerFactory.getLogger(FeignHttpController.class);


    @GetMapping("/call")
    public String index(){
        log.info("Nacos客户端[nacos-provider-a:节点a]收到请求");
        return String.format("Nacos客户端[nacos-provider-a:节点a]:返回了数据");
    }



}
