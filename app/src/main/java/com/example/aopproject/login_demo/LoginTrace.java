package com.example.aopproject.login_demo;

import android.content.Context;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author crazyZhangxl on 2019/1/28.
 * Describe: 需要登陆验证的切点 注意在interface前加入@
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginTrace {
    int type();
}
