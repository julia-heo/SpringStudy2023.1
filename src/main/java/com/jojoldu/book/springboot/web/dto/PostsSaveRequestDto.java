package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {     //Dto는 View를 위한 클래스. Entity와 유사하지만 엔티티는 DB와 맞닿은 핵심 클래스라 함부로 변경x
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title,String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
