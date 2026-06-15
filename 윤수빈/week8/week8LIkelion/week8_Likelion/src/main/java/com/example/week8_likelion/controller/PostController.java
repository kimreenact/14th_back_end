ppackage com.example.week8_likelion.controller;

import com.example.week8_likelion.dto.PostRequest;
import com.example.week8_likelion.dto.PostResponse;
import com.example.week8_likelion.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


// 브라우저로 띄웠던 Swagger 화면 맨 위에 이쁘게 제목과 설명을 달아주는 역할
@Tag(name = "게시글 API", description = "구조 분리 버전 - 게시글 CRUD 기능 제공")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    //구조 분리
    //Controller가 Service를 필요로 할 때, 외부에서 주입받아 사용하도록 유도함
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "1. 게시글 생성", description = "새로운 게시글을 등록합니다.")
    @PostMapping

    //클라이언트가 보낸 JSON 데이터를 자바 DTO(PostRequest)로 변환해서 받아옴
    //REST 관례에 맞춰 성공하면 '201 Created' 상태 코드로 반환함
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(request));
    }

    @Operation(summary = "2. 게시글 전체 조회", description = "등록된 모든 게시글 목록을 조회합니다.")
    @GetMapping

    // Postman 결과창에서 데이터가 널이 뜨거나 대괄호( [ ] ) 배열 형태로 쏟아지던 화면의 실체.
    // 여러 개의 게시글 응답 DTO를 묶어서 클라이언트에게 안전하게 뿌려줌.
    public ResponseEntity<List<PostResponse>> getAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @Operation(summary = "3. 게시글 상세 조회", description = "특정 ID를 가진 게시글 하나를 조회합니다.")
    @GetMapping("/{id}")

    //URL 경로 중간에 붙는 고유 ID값(/api/posts/1 등)을 자바 변수(Long id)로 쏙 추출해서 낚아채는 기술.
    //쿼리 스트링(Query Parameter)과 구별되는 RESTful API의 정석적인 설계 방식
    public ResponseEntity<PostResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @Operation(summary = "4. 게시글 수정", description = "특정 ID를 가진 게시글 내용을 수정합니다. (PATCH 방식)")
    @PatchMapping("/{id}")

    //전체 데이터를 무식하게 싹 다 갈아엎는 PUT 방식과 다르게,
    //변경하려는 특정 리소스의 필드값만 골라서 갱신할 때 사용하는 목적 지향적 HTTP 메서드
    public ResponseEntity<PostResponse> update(@PathVariable Long id, @RequestBody PostRequest request) {
        return ResponseEntity.ok(postService.update(id, request));
    }

    @Operation(summary = "5. 게시글 삭제", description = "특정 ID를 가진 게시글을 삭제합니다.")
    @DeleteMapping("/{id}")
    //데이터를 완전히 삭제한 후에는 따로 돌려줄 데이터 객체(DTO)가 없으므로,
    //"게시글이 삭제되었습니다."라는 단순 안내용 JSON 맵을 만들어서 반환함
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(Map.of("message", "게시글이 삭제되었습니다."));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    //없는 번호(999번 등)를 찔렀을 때, 브라우저나 Postman에 404 Not Found 상태 코드와 함께 깔끔한 에러 문구 JSON을 강제로 리턴
    public ResponseEntity<Map<String, String>> handleException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    }
}