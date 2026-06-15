package com.example.week8_likelion;

public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;


    // 스프링이 데이터 변환 할 떄, 이 비어있는 기본 생성자로 객체를 먼저 생성함.
    // 이게 없으면 포스트맨이나 Swagger로 JSON 데이터를 보낼 때 필드값이 누락되거나 null이 뜸.
    public Post() {}

    public Post(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }



    // 외부 데이터 바인딩이나 값 수정이 필요할 때 안정적으로 대처할 수 있도록 Getter 메서드들을 표준 규격으로 열어둠.
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }

    // 외부에서 필드값을 직접 마구잡이로 수정하지 못하게 막음.
    public void update(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    // 처음 글을 작성할 때는 ID가 없는 상태(null)로 Service 단에서 데이터가 넘어옴.
    public void setId(Long id) { this.id = id; }
    // 이후 저장소(Repository)에 최종 등록되면서 고유 번호가 발급되었을 때, 그 ID를 객체에 주입하기 위해 열어둔 통로 같은 거.
}