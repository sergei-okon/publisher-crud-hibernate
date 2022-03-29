package ua.com.okonsergei.model.dto;

import lombok.Data;
import ua.com.okonsergei.repository.entity.Post;

import java.util.List;

@Data
public class WriterDto {

    private Long id;
    private String name;
    private List<Post> posts;
}
