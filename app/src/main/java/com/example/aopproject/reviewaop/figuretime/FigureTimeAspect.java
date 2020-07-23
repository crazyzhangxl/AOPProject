package com.example.aopproject.reviewaop.figuretime;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by apple on 2020/7/23.
 * description: 统计时间切面
 */

@Aspect
public class FigureTimeAspect {

    @Pointcut("execution(@com.example.aopproject.reviewaop.figuretime.FigureTimeTrace * *(..))")
    public void cutPointMethod(){

    }

    @Around("cutPointMethod()")
    public void dealPoint(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            long runTime = System.currentTimeMillis() - startTime;
            String methodName = signature.getMethod().getName();
            Log.e("aspect", methodName+"  执行时间 = "+runTime );
        }
    }
}
