package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                 //롬복 어노테이션. 클래스 내 모든 필드의 Getter메소드 자동생성
@NoArgsConstructor      //롬복 어노테이션. 기본 생성자 자동 추가
@Entity                 //JPA 어노테이션, 필수. 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {        //실제 DB의 테이블과 매칭될 클래스=Entity 클래스
//extends BaseTimeEntity하면 엔티티 생기는 시간 저장 자동화
    @Id                                                     //테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //PK 생성 규칙
    private Long id;                                        //Entity의 PK는 Long 타입의 Auto_increment 추천

    @Column(length = 500, nullable = false)                 //테이블 칼럼. 추가변경 옵션. default varchar 255
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)     //타입변경
    private String content;

    private String author;

    @Builder                                                //빌더 패턴 클래스 생성. 필드-값 매칭
    public Posts(String title,String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }
}
//Entity클래스에는 Setter 메소드 절대 안만듦-생성자로 값 채움
