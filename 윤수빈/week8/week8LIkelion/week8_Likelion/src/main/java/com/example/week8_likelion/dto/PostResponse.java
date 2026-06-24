package com.example.week8_likelion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;




// 브라우저 화면에서 이 DTO가 어떤 데이터를 돌려주는지 한눈에 보게 해주는 주석 역할
// API 명세서 요건을 프로그램 내부에서 자동으로 채워줌
@Schema(description = "게시글 응답 데이터")
public class PostResponse {




    // 자바 변수 이름과 JSON의 키값을 무조건 1대1로 일치시켜 묶기
    @Schema(description = "게시글 ID"	, example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "글 제목", example = "첫 번째 게시글")
    @JsonProperty("title")
    private String title;

    @Schema(description = "글 내용", example = "안녕하세요")
    @JsonProperty("content")
    private String content;

    @Schema(description = "작성자", example = "현준")
    @JsonProperty("author")
    private String author;



    //DTO를 스프링이 다룰 때 내부적으로 뼈대를 잡기 위해 무조건 써야 함
    //알맹이가 비어있는 통을 먼저 개설할 때 자바가 사용하는 보이지 않는 열쇠
    public PostResponse() {}




    //서비스 단에서 DB나 저장소 데이터를 긁어와서 DTO 객체로 조립할 때 쓰는 통로
    public PostResponse(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }



    // 레코드 문법 대신 클래스를 쓰면서 스프링 내부 라이브러리가 데이터를 안전하게 읽어가도록 유도하기
    // 외부로 데이터를 리턴할 때 이 메서드들을 거쳐서 안전하게 출고 처리가 됨
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
}