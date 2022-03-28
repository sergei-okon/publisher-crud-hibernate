package ua.com.okonsergei.converter;

import ua.com.okonsergei.model.dto.WriterDto;
import ua.com.okonsergei.repository.db.entity.Writer;

public class WriterConverter {

    public static WriterDto convertToDTO(Writer writer) {
        WriterDto writerDto = new WriterDto();
        writerDto.setId(writer.getId());
        writerDto.setName(writer.getName());
        writerDto.setPosts(writer.getPosts());
        return writerDto;
    }

    public static Writer convertToEntity(WriterDto writerDto) {
        Writer writer = new Writer();
        writer.setId(writerDto.getId());
        writer.setName(writerDto.getName());
        writer.setPosts(writerDto.getPosts());
        return writer;
    }
}
