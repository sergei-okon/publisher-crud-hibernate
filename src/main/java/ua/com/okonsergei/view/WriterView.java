package ua.com.okonsergei.view;

import ua.com.okonsergei.controller.PostController;
import ua.com.okonsergei.controller.WriterController;
import ua.com.okonsergei.converter.PostConverter;
import ua.com.okonsergei.model.dto.PostDto;
import ua.com.okonsergei.model.dto.WriterDto;
import ua.com.okonsergei.repository.entity.Post;

import java.util.*;
import java.util.stream.Collectors;

public class WriterView extends BaseView {

    private final WriterController writerController;
    private final PostController postController;
    private final Scanner scanner = new Scanner(System.in);

    public WriterView(WriterController writerController, PostController postController) {
        this.writerController = writerController;
        this.postController = postController;
    }

    @Override
    void create() {
        WriterDto writerDto = new WriterDto();
        fillWriterDtoFromConsoleWithData(writerDto);
        writerController.save(writerDto);
        System.out.println(Message.SUCCESSFUL_OPERATION.getMessage());
    }

    @Override
    void edit() {
        Long id = getValidateIdFromScanner();

        if (writerController.findById(id) == null) {
            System.out.println("Post with id " + id + " not found");
            return;
        }

        WriterDto writerDto = new WriterDto();
        fillWriterDtoFromConsoleWithData(writerDto);
        writerDto.setId(id);
        writerController.update(writerDto);
    }

    @Override
    void delete() {
        Long id = getValidateIdFromScanner();
        writerController.deleteById(id);
    }

    @Override
    void findAll() {
        System.out.println("Writers List");
        writerController.findAll().forEach(System.out::println);
    }

    @Override
    void showSecondMenu() {
        System.out.println("WRITER control menu. What do you want to do?");
        super.showSecondMenu();
    }

    private void fillWriterDtoFromConsoleWithData(WriterDto writerDto) {
        System.out.println("Input Writer name");
        String firstName = scanner.next();
        System.out.println("Input Posts id via ' , ' ");
        scanner.nextLine();
        String post = scanner.nextLine();

        List<Post> posts = new ArrayList<>();

        String[] postIds = post.replace(" ", "").split(",");
        Set<String> uniquePostIds = Arrays.stream(postIds).collect(Collectors.toSet());

        for (String id : uniquePostIds) {
            PostDto byId = postController.findById(Long.valueOf(id));

            if (byId.getId() == null) {
                System.out.println("Id of Post " + id + " is not present in DB");
            } else {
                posts.add(PostConverter.convertToEntity(byId));
            }
        }
        writerDto.setName(firstName);
        writerDto.setPosts(posts);
    }
}
