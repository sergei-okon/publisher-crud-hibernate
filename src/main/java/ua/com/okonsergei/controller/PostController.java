package ua.com.okonsergei.controller;

import ua.com.okonsergei.converter.PostConverter;
import ua.com.okonsergei.model.dto.PostDto;
import ua.com.okonsergei.repository.db.entity.Post;
import ua.com.okonsergei.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public List<PostDto> findAll() {
        return postService.findAll().stream()
                .map(PostConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public PostDto findById(Long id) {
        return PostConverter.convertToDTO(postService.findById(id));
    }

    public Post save(PostDto postDto) {
        return postService.save(PostConverter.convertToEntity(postDto));
    }

    public void deleteById(Long id) {
        postService.deleteById(id);
    }

    public void update(PostDto postDto) {
        postService.update(PostConverter.convertToEntity(postDto));
    }
}


