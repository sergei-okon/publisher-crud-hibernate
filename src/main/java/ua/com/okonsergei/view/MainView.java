package ua.com.okonsergei.view;

import ua.com.okonsergei.controller.TagController;
import ua.com.okonsergei.controller.PostController;
import ua.com.okonsergei.controller.WriterController;
import ua.com.okonsergei.repository.PostRepository;
import ua.com.okonsergei.repository.TagRepository;
import ua.com.okonsergei.repository.WriterRepository;
import ua.com.okonsergei.repository.db.hibernate.PostRepositoryImpl;
import ua.com.okonsergei.repository.db.hibernate.WriterRepositoryImpl;
import ua.com.okonsergei.repository.db.hibernate.TagRepositoryImpl;
import ua.com.okonsergei.service.TagService;
import ua.com.okonsergei.service.PostService;
import ua.com.okonsergei.service.WriterService;

import java.util.Scanner;

public class MainView {

    private final PostRepository postRepository = new PostRepositoryImpl();
    private final WriterRepository writerRepository = new WriterRepositoryImpl();
    private final TagRepository labelRepository = new TagRepositoryImpl();

    private final WriterService writerService = new WriterService(writerRepository);
    private final PostService postService = new PostService(postRepository);
    private final TagService tagService = new TagService(labelRepository);

    private final WriterController writerController = new WriterController(writerService);
    private final PostController postController = new PostController(postService);
    private final TagController tagController = new TagController(tagService);

    private final WriterView writerView = new WriterView(writerController, postController);
    private final TagView tagView = new TagView(tagController);
    private final PostView postView = new PostView(postController, tagController);

    private final Scanner scanner = new Scanner(System.in);

    public void run() {

        String mainMenu = """
                MAIN MENU
                Make your choice:
                1 Writer
                2 Tag
                3 Post
                ____________________________________________
                0 Exit""";

        boolean exit = false;
        while (!exit) {
            System.out.println(Message.LINE.getMessage() + "\n" + mainMenu);
            String input = scanner.next();

            switch (input) {
                case "1" -> writerView.showSecondMenu();
                case "2" -> tagView.showSecondMenu();
                case "3" -> postView.showSecondMenu();
                case "0" -> exit = true;
                default -> System.out.println(Message.ERROR_INPUT.getMessage());
            }
        }
    }
}



