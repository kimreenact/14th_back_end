package com.example.week8_likelion.service;

import com.example.week8_likelion.Post;
import com.example.week8_likelion.dto.PostRequest;
import com.example.week8_likelion.dto.PostResponse;
import com.example.week8_likelion.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;




// 컨트롤러가 요청을 받으면 실제 연산이나 데이터 가공 및 트랜잭션 처리
@Service
public class PostService {
    private final PostRepository postRepository;

    // 서비스가 직접 저장소 객체를 new 해서 만들지 않고 스프링 컨테이너가 생성자를 통해 주입
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse create(PostRequest request) {
        // 클라이언트가 보낸 요청 DTO 알맹이를 꺼내서 순수한 Post 객체로 조립한 뒤 저장소 넘기기
        Post post = new Post(null, request.getTitle(), request.getContent(), request.getAuthor());
        Post savedPost = postRepository.save(post);


        // 최종 응답을 내보낼 때는 ID가 채워진 응답 전용 DTO 객체로 다시 변환하여 전달
        return new PostResponse(savedPost.getId(), savedPost.getTitle(), savedPost.getContent(), savedPost.getAuthor());
    }

    public List<PostResponse> getAll() {
        // 저장소에서 긁어온 순수한 Post 리스트 목록을 stream()과 map() 함수를 통해 가공
        // 모든 원소들을 응답용 데이터 묶음인 PostResponse 객체로 하나하나 변환하여 최종 리스트로 반환
        return postRepository.findAll().stream()
                .map(post -> new PostResponse(post.getId(), post.getTitle(), post.getContent(), post.getAuthor()))
                .collect(Collectors.toList());
    }

    public PostResponse getById(Long id) {
        // 저장소에서 꺼낸 데이터가 만약 null인 경우를 대비해 orElseThrow() 방어 코드
        // 없는 글 번호를 조회하면 에러를 터트려 컨트롤러의 ExceptionHandler로 유도
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다 ID: " + id));
        return new PostResponse(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

    public PostResponse update(Long id, PostRequest request) {
        // 먼저 수정할 데이터가 존재하는지 ID 조회를 통해 꼼꼼하게 유효성 검증을 마침
        // 데이터가 확인되면 Post 객체 내부의 update 메서드를 호출해 값을 안전하게 동기화하고 변경함
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다 ID: " + id));

        post.update(request.getTitle(), request.getContent(), request.getAuthor());
        Post updatedPost = postRepository.save(post);
        return new PostResponse(updatedPost.getId(), updatedPost.getTitle(), updatedPost.getContent(), updatedPost.getAuthor());
    }




    public void delete(Long id) {
        //레포지토리에서 데이터를 삭제하고 받아온 boolean 결과값(true/false)을 분석
        //지우려는 번호가 애초에 없어서 false가 리턴되면 삭제 실패 예외 메세지를 던져 시스템을 보호
        boolean deleted = postRepository.deleteById(id);
        if (!deleted) {
            throw new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다 ID: " + id);
        }
    }
}