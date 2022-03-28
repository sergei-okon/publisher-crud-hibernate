package ua.com.okonsergei.view;

import ua.com.okonsergei.controller.PostController;
import ua.com.okonsergei.controller.TagController;
import ua.com.okonsergei.converter.TagConverter;
import ua.com.okonsergei.model.dto.PostDto;
import ua.com.okonsergei.model.dto.TagDto;
import ua.com.okonsergei.repository.db.entity.PostStatus;
import ua.com.okonsergei.repository.db.entity.Tag;

import java.util.*;
import java.util.stream.Collectors;

public class PostView extends BaseView {

    private final PostController postController;
    private final TagController tagController;
    private final Scanner scanner = new Scanner(System.in);

    public PostView(PostController postController, TagController tagController) {
        this.postController = postController;
        this.tagController = tagController;
    }

    @Override
    void create() {
        PostDto postDto = new PostDto();
        fillWriterDtoFromConsoleWithData(postDto);
        postController.save(postDto);
        System.out.println(Message.SUCCESSFUL_OPERATION.getMessage());
    }

    @Override
    void edit() {
        Long id = getValidateIdFromScanner();

        if (postController.findById(id) == null) {
            System.out.println("Post with id " + id + " not found");
            return;
        }
        PostDto postDto = new PostDto();
        fillWriterDtoFromConsoleWithData(postDto);
        postDto.setId(id);
        postController.update(postDto);
    }

    @Override
    void delete() {
        Long id = getValidateIdFromScanner();
        postController.deleteById(id);
    }

    @Override
    void findAll() {
        System.out.println("Post List");
        postController.findAll().forEach(System.out::println);
    }

    public void showSecondMenu() {
        System.out.println("Post control menu. What do you want to do?");
        super.showSecondMenu();
    }

    private void fillWriterDtoFromConsoleWithData(PostDto postDto) {
        System.out.println("Input POST new content");
        String content = scanner.next();
        System.out.println("Input Tags id via ' , ' ");
        scanner.nextLine();
        String tag = scanner.nextLine();

        List<Tag> tags = new ArrayList<>();
        String[] tagsId = tag.replace(" ", "").split(",");
        Set<String> uniqueTagIds = Arrays.stream(tagsId).collect(Collectors.toSet());

        for (String id : uniqueTagIds) {
            TagDto byId = tagController.findById(Long.valueOf(id));

            if (byId.getId() == null) {
                System.out.println("Id of tag " + id + " is not present in DB");
            } else {
                tags.add(TagConverter.convertToEntity(byId));
            }
        }
        postDto.setContent(content);
        postDto.setStatus(PostStatus.ACTIVE);
        postDto.setTags(tags);
    }
}
