package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)          //이 어노테이션이 생성 위치 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {           //이 파일을 어노테이션 클래스로 지정
}
