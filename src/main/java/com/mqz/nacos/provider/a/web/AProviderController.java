package com.mqz.nacos.provider.a.web;

import com.mqz.nacos.provider.a.common.WebRequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mqz
 * @description
 * @abount https://github.com/DemoMeng
 * @since 2021/2/24
 */
@RestController
@RequestMapping(WebRequestMapping.PREFIX+"/a")
@RefreshScope //动态刷新读取Nacos配置文件
@Api(tags = "web测试-读取网关配置入口",value = "web测试-读取网关配置入口")
public class AProviderController {

    private final static Logger log = LoggerFactory.getLogger(AProviderController.class);


    //@NacosValue(value = "${name:默认name}", autoRefreshed = true)
    @Value(value = "${name:ccc}")
    private String configName;

    @GetMapping("/{name}")
    @ApiOperation(value = "读取配置中心中的配置")
    public String index(@PathVariable(name = "name") String name){
        log.info("Nacos客户端[nacos-provider-a]收到请求");
        log.info("配置中心："+configName);
        return String.format("Nacos客户端[nacos-provider-a]:你好，%s。配置中心：%s",name,configName);
    }

}
