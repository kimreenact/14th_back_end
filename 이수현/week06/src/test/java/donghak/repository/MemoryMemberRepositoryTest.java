package donghak.repository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import donghak.domain.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // test 서로 의존관계 없이 설계가 되어야 하기에 사용.
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("DONGHAK1");

        repository.save(member);

        Member result = repository.findMyId(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName() {


        Member member1 = new Member();
        member1.setName("DONGHAK1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("DONGHAK2");
        repository.save(member2);

        Member result = repository.findByName("DONGHAK1").get();

        assertThat(result).isEqualTo(member1);

    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("DONGHAK1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("DONGHAK2");
        repository.save(member2);

        List<Member> result  = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
