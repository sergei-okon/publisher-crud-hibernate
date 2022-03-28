package ua.com.okonsergei.service;

import ua.com.okonsergei.repository.TagRepository;
import ua.com.okonsergei.repository.db.entity.Tag;

import java.util.List;

public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Tag findById(Long id) {
        return tagRepository.findById(id);
    }

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    public void update(Tag tag) {
        tagRepository.update(tag);
    }
}
