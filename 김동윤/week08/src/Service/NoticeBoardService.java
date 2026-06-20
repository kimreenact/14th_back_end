package com.likeLion.LikeLion_SpringBoot_Assignment.Service;

import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request.NoticeBoardCreateDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request.NoticeBoardUpdateDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Response.NoticeBoardResponseDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.Domain.Post;
import com.likeLion.LikeLion_SpringBoot_Assignment.Repository.NoticeBoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeBoardService {
    private final NoticeBoardRepository noticeBoardRepository;

    public NoticeBoardService (NoticeBoardRepository noticeBoardRepository) {
        this.noticeBoardRepository = noticeBoardRepository;
    }

    public NoticeBoardResponseDTO save(NoticeBoardCreateDTO noticeBoardCreateDTO) {
        return NoticeBoardResponseDTO.from(noticeBoardRepository.save(noticeBoardCreateDTO));
    }

    public List<NoticeBoardResponseDTO> findAll() {
        return noticeBoardRepository.findAll().stream().map(NoticeBoardResponseDTO::from).toList();
    }

    public NoticeBoardResponseDTO findById(Long id) {
        Post post = noticeBoardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        return NoticeBoardResponseDTO.from(post);
    }

    public Post update(Long id, NoticeBoardUpdateDTO noticeBoardUpdateDTO) {
        return noticeBoardRepository.update(id, noticeBoardUpdateDTO);
    }

    public void deleteById(Long id) {
        noticeBoardRepository.deleteById(id);
    }
}