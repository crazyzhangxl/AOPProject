package com.example.aopproject.login_demo;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.aopproject.MyApp;
import com.example.aopproject.UserCache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author crazyZhangxl on 2019/1/28.
 * Describe: 切面
 */
@Aspect
public class LoginAspect {

    /**
     * 对含有某个方法的特定注解打上切点
     */
    @Pointcut("execution(@com.example.aopproject.login_demo.LoginTrace * *(..))")
    public void pointCutLogin(){

    }

    /**
     * 处理 特定的打上切点的方法
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    @Around("pointCutLogin()")
    public void aroundLogin(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (UserCache.getInstance().isLogin()){
            proceedingJoinPoint.proceed();
        }else {
            if (proceedingJoinPoint.getThis() instanceof Context){
                // 获得注解参数
                MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
                LoginTrace annotation = signature.getMethod().getAnnotation(LoginTrace.class);
                int type = annotation.type();

                dealWithType(type,(Context) proceedingJoinPoint.getThis());
            }
        }
    }

    /**
     * 在这里处理是弹出dialog呢还是跳转界面呢 等等
     * @param type
     * @param context
     */
    private void dealWithType(int type,Context context){
        switch (type){
            case 0:
                Intent intent = new Intent(context,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
                default:
                    Toast.makeText( context,"请先进行登陆!", Toast.LENGTH_SHORT).show();
                    break;
        }
    }
}
