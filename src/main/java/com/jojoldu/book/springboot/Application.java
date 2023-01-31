//앞으로 만들 프로젝트의 메인 클래스
package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing                  //JPA Auditing 활성화_자동으로 시간을 매핑하여 데이터베이스의 테이블에 넣어줌
@SpringBootApplication              //스프링 부트의 자동 설정
public class Application {          //항상 프로젝트 최상단에 위치하는 클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
