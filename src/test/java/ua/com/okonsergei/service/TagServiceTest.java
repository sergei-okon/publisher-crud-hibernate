package ua.com.okonsergei.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.okonsergei.repository.db.entity.Tag;
import ua.com.okonsergei.repository.TagRepository;
import ua.com.okonsergei.repository.db.hibernate.TagRepositoryImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class TagServiceTest {

    TagRepository tagRepositoryMock;
    TagService tagService;

    @BeforeEach
    void setUp() {
        tagRepositoryMock = mock(TagRepositoryImpl.class);
        tagService = new TagService(tagRepositoryMock);
    }

    @Test
    void findAll_Success() {
        tagService.findAll();
        verify(tagRepositoryMock).findAll();
    }

    @Test
    void findById_Success() {
        Long id = 5L;
        tagService.findById(id);
        verify(tagRepositoryMock).findById(id);
    }

    @Test
    void save_Success() {
        Tag tag = new Tag();

        tagService.save(tag);
        verify(tagRepositoryMock).save(tag);
    }

    @Test
    void deleteById_Success() {
        Long id = 5L;

        tagService.deleteById(id);
        verify(tagRepositoryMock).deleteById(id);
    }

    @Test
    void update_Success() {
        Tag tag = new Tag();

        tagService.update(tag);
        verify(tagRepositoryMock).update(tag);
    }
}