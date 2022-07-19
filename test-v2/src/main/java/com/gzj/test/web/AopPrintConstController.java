package com.gzj.test.web;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 3. 所有/class打头的请求，在执行开始时输出`class模块方法执行开始`，在执行结束时输出`class模块方法执行结束
 */

@Aspect
@Component
@Slf4j
public class AopPrintConstController {

    /**
     * 横切点，哪些方法需要被横切.
     */
    @Pointcut(value = "execution(public * com.gzj.test.controller.TbClassController.*(..))")
    public void pointCut1() { }

    @Pointcut(value = "execution(public * com.gzj.test.controller.TbClassController.*(..))")
    private void pointCut2(){ }

    @Pointcut(value = "execution(public * com.gzj.test.controller.TbClassController.*(..))")
    private void pointCut3() { }

    @Pointcut(value = "execution(public * com.gzj.test.controller.TbClassController.*(..))")
    private void pointCut4() { }

    // 前置通知，与切入点绑定
    @Before(value = "AopPrintConstController.pointCut1()")
    public void before(JoinPoint joinPoint) {
        // 获得切入点的信息
        System.out.println("前置通知执行！" + joinPoint);
        log.info("class模块方法执行开始");
    }

    // 后置通知
    @AfterReturning(value = "AopPrintConstController.pointCut2()", returning="result")
    public void afterReturning(Object result) {
        // 获取切入点方法的返回值
        System.out.println("后置通知执行！" + result);
        log.info("class模块方法执行结束");
    }

    /*
    // 环绕通知：传入参数，可执行切入点，返回值类型为Object
    @Around(value = "AopPrintConstController.pointCut3()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知执行！");
        Object obj = joinPoint.proceed();
        System.out.println("环绕后通知执行！");
        return obj;
    }

    // 异常通知
    @AfterThrowing(value = "AopPrintConstController.pointCut4()", throwing = "e")
    public void afterThrowing(Throwable e) {
        // 获取切入点的异常信息
        System.out.println("异常抛出通知执行！" + e.getMessage());
    }

    // 最终通知：无论程序是否出现异常，都会执行的通知
    @After(value = "AopPrintConstController.pointCut4()")
    public void after() {
        System.out.println("最终通知执行！");
    }
     */

}