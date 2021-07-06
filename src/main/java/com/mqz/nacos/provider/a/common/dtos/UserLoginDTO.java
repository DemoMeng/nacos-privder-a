package com.mqz.nacos.provider.a.common.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021/7/6 3:49 下午
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "登陆请求实体",description = "登陆请求实体")
public class UserLoginDTO implements Serializable {

    //TODO 非空校验
    @ApiModelProperty(value = "登陆账号",example = "13128507506",dataType = "String")
    private String account;

    @ApiModelProperty(value = "密码",example = "123456",dataType = "String")
    private String password;


}
