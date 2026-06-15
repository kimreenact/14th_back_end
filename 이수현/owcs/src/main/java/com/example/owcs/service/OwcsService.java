package com.example.owcs.service;

import com.example.owcs.domain.Owcs;
import com.example.owcs.dto.OwcsCreateRequest;
import com.example.owcs.dto.OwcsResponse;
import com.example.owcs.dto.OwcsUpdateRequest;
import com.example.owcs.repository.OwcsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwcsService {

    private final OwcsRepository owcsRepository;
    public OwcsService(OwcsRepository owcsRepository){
        this.owcsRepository = owcsRepository;
    }

    public OwcsResponse create(OwcsCreateRequest request) {
        Owcs owcs = owcsRepository.save(
                request.team(),
                request.nickname(),
                request.position(),
                request.heros()
        );
        return OwcsResponse.from(owcs);
    }

    public List<OwcsResponse> findAll() {
        return owcsRepository.findAll()
                .stream()
                .map(OwcsResponse::from)
                .toList();

    }


    public OwcsResponse findById(Long id) {
        Owcs owcs = owcsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Can't find Player"));
        return OwcsResponse.from(owcs);
    }

    public OwcsResponse update(Long id, OwcsUpdateRequest request) {
        Owcs owcs = owcsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Can't find Player"));

        owcs.update(
                request.team(),
                request.nickname(),
                request.position(),
                request.heros()
        );
        return  OwcsResponse.from(owcs);
    }

    public void delete(Long id) {
        Owcs owcs = owcsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Can't fidn Player"));

        owcsRepository.deleteById(id);
    }
}