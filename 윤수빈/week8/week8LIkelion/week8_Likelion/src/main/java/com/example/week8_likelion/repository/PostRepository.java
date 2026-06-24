package com.example.week8_likelion.repository;

import com.example.week8_likelion.Post;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {


    //실제 DB를 연결하기 전에 서버 메모리에 데이터를 올려두는 가짜 데이터베이스 매핑 공간
    //여러 사용자가 동시에 글을 써도 데이터가 꼬이거나 깨지지 않게 해주는 동시성 보장용 자료구조를 사용
    private final Map<Long, Post> store = new ConcurrentHashMap<>();


    //글이 생성될 때마다 1번 2번 3번 순서대로 중복 없이 안전하게 번호를 올려주는 역할을 함
    //멀티스레드 환경에서도 안전하게 번호를 1씩 증가시켜 주는 특수한 자바 클래스
    private final AtomicLong sequence = new AtomicLong(0);


    public Post save(Post post) {

        //처음에 글을 쓸 때는 ID가 없기 때문에 sequence를 작동시켜서 새로운 번호를 발급해 줌
        //만약 기존에 글이 있어서 ID를 들고 넘어왔다면 번호 발급을 건너뛰고 맵에 그대로 덮어쓰며 수정
        if (post.getId() == null) {
            post.setId(sequence.incrementAndGet());
        }
        store.put(post.getId(), post);
        return post;
    }

    public List<Post> findAll() {
        //컨트롤러와 서비스가 원하는 대괄호 배열 형태의 JSON 결과를 만들기 위한 밑작업
        //내부 저장소에 흩어져 있는 Post 객체들을 한곳에 모아 순수한 ArrayList 구조로 포장해서 던져줌
        return new ArrayList<>(store.values());
    }

    public Optional<Post> findById(Long id) {
        //존재하지 않는 글 번호(999번 등)를 찾으려고 할 때 자바 내부에서 발생하는 null 에러를 방지함
        //값이 있을 수도 있고 없을 수도 있다는 것을 서비스 단에 안전하게 알려주는 자바 표준 래퍼 클래스.
        return Optional.ofNullable(store.get(id));
    }

    public boolean deleteById(Long id) {
        // 지우려는 글 번호가 맵에 존재해서 정상적으로 삭제가 완료되면 true를 반환함
        // 애초에 없는 번호라서 삭제에 실패하면 false를 리턴하여 서비스 단에서 예외 처리를 할 수 있게 도와줌
        return store.remove(id) != null;
    }
}