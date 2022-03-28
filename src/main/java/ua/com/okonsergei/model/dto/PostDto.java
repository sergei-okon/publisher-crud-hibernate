package ua.com.okonsergei.model.dto;

import lombok.Data;
import ua.com.okonsergei.repository.db.entity.PostStatus;
import ua.com.okonsergei.repository.db.entity.Tag;

import java.util.List;

@Data
public class PostDto {

    private Long id;
    private String content;
    private PostStatus status;
    private List<Tag> tags;
}
