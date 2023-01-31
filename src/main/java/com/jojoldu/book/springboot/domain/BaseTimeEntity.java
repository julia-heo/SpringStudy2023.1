//생성시간/수정시간 자동화하기
//엔티티가 언제 만들어졌는지, 수정되었는지
package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass                               //필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity 클래스에 Auditing 기능 포함
public class BaseTimeEntity {
    @CreatedDate                                //Entity 생성되어 저장될 때 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate                           //조회한 Entity값 변경할 때 시간 자동저장
    private LocalDateTime modifiedDate;
}
