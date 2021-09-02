package com.mqz.nacos.provider.a.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021/9/2 11:21 上午
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "手机")
    private String phone;
    @ApiModelProperty(value = "地址")
    private String address;
}
