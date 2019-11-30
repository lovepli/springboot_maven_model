package com.example.demo.biz.exception;

import com.example.demo.common.error.ServiceErrors;

/**
 * @author linjian
 * @date 2019/3/15
 * 自定义异常类
 */
public class BizException extends RuntimeException {

    private final Integer code;

    public BizException(ServiceErrors errors) {
        super(errors.getMessage());
        this.code = errors.getCode();
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
