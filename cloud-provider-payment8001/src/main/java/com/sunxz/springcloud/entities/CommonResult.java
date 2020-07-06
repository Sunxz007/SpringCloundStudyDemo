package com.sunxz.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Json响应体
 * @author sun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * 响应编码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应体
     */
    private T data;

    /**
     * 成功响应的简单参数
     * @param code 响应编码
     * @param message 响应信息
     */
    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
