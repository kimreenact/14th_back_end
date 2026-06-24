package com.example.owcs.repository;

import com.example.owcs.domain.Owcs;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OwcsRepository {

    private final List<Owcs> owcsList = new ArrayList<>();
    private Long idCounter = 1L;

    public Owcs save(String team, String nickname, String position, String heros) {
        Owcs owcs = new Owcs(idCounter++,team,nickname,position,heros);
        owcsList.add(owcs);
        return owcs;
    }

    public List<Owcs> findAll() {

        return owcsList;
    }

    public Optional<Owcs> findById(Long id) {
        // owcsList에서 id가 일치하는 것 찾기
        return owcsList.stream()
                .filter(Owcs -> Owcs.getId().equals(id))
                .findFirst();

    }

    public void deleteById(Long id) {
        // owcsList에서 id가 일치하는 것 삭제
        owcsList.removeIf(owcs -> owcs.getId().equals(id));
    }
}