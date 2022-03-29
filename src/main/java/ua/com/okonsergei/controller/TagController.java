package ua.com.okonsergei.controller;

import ua.com.okonsergei.converter.TagConverter;
import ua.com.okonsergei.model.dto.TagDto;
import ua.com.okonsergei.repository.entity.Tag;
import ua.com.okonsergei.service.TagService;

import java.util.List;
import java.util.stream.Collectors;

public class TagController {

    TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    public List<TagDto> findAll() {
        return tagService.findAll().stream()
                .map(TagConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public TagDto findById(Long id) {
        return TagConverter.convertToDTO(tagService.findById(id));
    }

    public Tag save(TagDto tagDto) {
        return tagService.save(TagConverter.convertToEntity(tagDto));
    }

    public void deleteById(Long id) {
        tagService.deleteById(id);
    }

    public void update(TagDto tagDto) {
        tagService.update(TagConverter.convertToEntity(tagDto));
    }
}
