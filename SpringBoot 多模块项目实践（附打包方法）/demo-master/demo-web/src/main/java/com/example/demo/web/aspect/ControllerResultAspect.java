package com.example.demo.web.aspect;

import com.example.demo.biz.exception.BizException;
import com.example.demo.common.entity.Result;
import com.example.demo.common.error.DemoErrors;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author linjian
 * @date 2019/3/19
 */
@Slf4j
@Aspect
@Component
public class ControllerResultAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)" +
            "&& execution(com.example.demo.common.entity.Result *.*(..))")
    public void controllerResult() {
    }

    @Around("controllerResult()")
    public Result doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = new Result();
        try {
            result = (Result) proceedingJoinPoint.proceed();
        } catch (BizException e) { //自定义异常
            result.setSuccess(false);
            result.setCode(e.getCode());
            result.setMessage(e.getMessage());
        } catch (IllegalArgumentException e) { //违反的参数异常
            result.setSuccess(false);
            result.setCode(DemoErrors.PARAM_ERROR.getCode());
            result.setMessage(e.getMessage());
        } catch (RuntimeException e) {  //运行时异常
            log.error("系统出错", e);
            result.setSuccess(false);
            result.setCode(DemoErrors.SYSTEM_ERROR.getCode());
            result.setMessage(DemoErrors.SYSTEM_ERROR.getMessage());
        }
        return result;
    }
}
