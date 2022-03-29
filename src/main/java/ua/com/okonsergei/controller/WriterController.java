package ua.com.okonsergei.controller;

import ua.com.okonsergei.converter.WriterConverter;
import ua.com.okonsergei.model.dto.WriterDto;
import ua.com.okonsergei.repository.entity.Writer;
import ua.com.okonsergei.service.WriterService;

import java.util.List;
import java.util.stream.Collectors;

public class WriterController {

    WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    public List<WriterDto> findAll() {
        return writerService.findAll().stream()
                .map(WriterConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public WriterDto findById(Long id) {
        return WriterConverter.convertToDTO(writerService.findById(id));
    }

    public Writer save(WriterDto writerDto) {
        return writerService.save(WriterConverter.convertToEntity(writerDto));
    }

    public void deleteById(Long id) {
        writerService.deleteById(id);
    }

    public void update(WriterDto writerDto) {
        writerService.update(WriterConverter.convertToEntity(writerDto));
    }
}

