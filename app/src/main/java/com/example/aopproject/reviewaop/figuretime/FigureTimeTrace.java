package com.example.aopproject.reviewaop.figuretime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by apple on 2020/7/23.
 * description:统计时间的注解
 */
// 定义注解作用对象
// 定义注解周期
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface FigureTimeTrace {
}
