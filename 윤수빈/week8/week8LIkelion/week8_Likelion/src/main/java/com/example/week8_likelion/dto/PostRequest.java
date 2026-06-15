package com.example.week8_likelion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


//화면이나 포스트맨에서 넘어오는 순수한 입력 데이터 값들만 따로 담기 위한 전용 객체
//DB에 직접 닿는 도메인 클래스를 보호하기 위해 앞단에서 방패 같은 거
@Schema(description = "게시글 요청 데이터")
public class PostRequest {


    //포스트맨 raw 탭에 적은 텍스트를 자바 필드로 강제 매핑
    @Schema(description = "글 제목", example = "첫 번째 게시글")
    @JsonProperty("title")
    private String title;

    @Schema(description = "글 내용", example = "안녕하세요")
    @JsonProperty("content")
    private String content;

    @Schema(description = "작성자", example = "현준")
    @JsonProperty("author")
    private String author;


    //네트워크로 전송된 JSON 데이터를 자바 객체로 역직렬화할 때 스프링이 가장 먼저 호출함
    //이게 없으면 스프링이 요청 데이터를 담을 그릇 자체를 만들지 못해 에러 발생
    public PostRequest() {}



    //테스트 코드나 다른 서비스 로직에서 직접 요청 객체를 가짜로 만들어서 넣고 싶을 때 사용
    //세 가지 필수 필드 데이터를 한 번에 밀어 넣어서 객체를 완성시키는 통로
    public PostRequest(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }




    // 레코드 문법의 request title() 방식 대신 자바 정석 규격인 request getTitle()을 지원함
    // 컨트롤러가 데이터를 받아서 서비스 단에 알맹이를 안전하게 넘겨줄 때 활용되는 출구임
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
}