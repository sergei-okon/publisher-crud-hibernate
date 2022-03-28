package ua.com.okonsergei.converter;

import ua.com.okonsergei.model.dto.PostDto;
import ua.com.okonsergei.repository.db.entity.Post;

public class PostConverter {

    public static PostDto convertToDTO(Post post) {
        PostDto postDto = new PostDto();
        if (post != null) {
            postDto.setId(post.getId());
            postDto.setContent(post.getContent());
            postDto.setStatus(post.getStatus());
            postDto.setTags(post.getTags());
        }
        return postDto;
    }

    public static Post convertToEntity(PostDto postDto) {
        Post post = new Post();
        if (postDto != null) {
            post.setId(postDto.getId());
            post.setContent(postDto.getContent());
            post.setStatus(postDto.getStatus());
            post.setTags(postDto.getTags());
        }
        return post;
    }
}
