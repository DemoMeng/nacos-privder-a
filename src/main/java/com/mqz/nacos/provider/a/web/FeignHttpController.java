package com.mqz.nacos.provider.a.web;


import com.mqz.mars.validation.exceptions.ParamValidException;
import com.mqz.nacos.provider.a.common.User;
import com.mqz.nacos.provider.a.common.WebRequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author mqz
 * @description
 * @abount https://github.com/DemoMeng
 * @since 2021/2/24
 */
@RestController
@RequestMapping(WebRequestMapping.PREFIX+"/feign")
@RefreshScope //动态刷新读取Nacos配置文件
@Api(tags = "web测试-提供feign入口",value = "web测试-提供feign")
public class FeignHttpController {

    private final static Logger log = LoggerFactory.getLogger(FeignHttpController.class);


    @GetMapping("/call")
    @ApiOperation(value = "提供feign调用接口")
    public String index(){
        log.info("Nacos客户端[nacos-provider-a:节点a]收到请求");
        if(true){
            throw new ParamValidException("[nacos-provider-a]抛出了异常");
        }
        return String.format("Nacos客户端[nacos-provider-a:节点a]:返回了数据");
    }


    @GetMapping("/call/1")
    @ApiOperation(value = "提供feign调用接口-测试@ReqeustParam")
    public String call1(@RequestParam(name = "name") String name){
        log.info("Nacos客户端[nacos-provider-a:节点a]收到请求");
        log.info("【参数】：{}",name);
        return String.format("Nacos客户端[nacos-provider-a:节点a]:返回了数据");
    }

    @PostMapping("/call/2")
    @ApiOperation(value = "提供feign调用接口-测试实体参数")
    public String call2(@RequestBody User user){
        log.info("Nacos客户端[nacos-provider-a:节点a]收到请求");
        log.info("【参数】：{}",user.toString());
        return String.format("Nacos客户端[nacos-provider-a:节点a]:返回了数据");
    }

    @PostMapping("/call/3")
    @ApiOperation(value = "提供feign调用接口-测试@RequestHeader")
    public String call3(@RequestHeader(name = "token") String token){
        log.info("Nacos客户端[nacos-provider-a:节点a]收到请求");
        log.info("【参数】：{}",token);
        return String.format("Nacos客户端[nacos-provider-a:节点a]:返回了数据");
    }



}
