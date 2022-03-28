package ua.com.okonsergei.converter;

import ua.com.okonsergei.model.dto.TagDto;
import ua.com.okonsergei.repository.db.entity.Tag;

public class TagConverter {

    public static TagDto convertToDTO(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setId(tag.getId());
        tagDto.setName(tag.getName());
        return tagDto;
    }

    public static Tag convertToEntity(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setId(tagDto.getId());
        tag.setName(tagDto.getName());
        return tag;
    }
}