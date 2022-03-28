package ua.com.okonsergei.view;

import ua.com.okonsergei.controller.TagController;
import ua.com.okonsergei.model.dto.TagDto;

import java.util.Scanner;

public class TagView extends BaseView {

    private final TagController tagController;
    private final Scanner scanner = new Scanner(System.in);

    public TagView(TagController tagController) {
        this.tagController = tagController;
    }

    @Override
    void create() {
        System.out.println("Input Tag name");
        String name = scanner.next();

        TagDto tagDto = new TagDto();
        tagDto.setName(name);
        tagController.save(tagDto);
        System.out.println(Message.SUCCESSFUL_OPERATION.getMessage());
    }

    @Override
    void edit() {
        Long id = getValidateIdFromScanner();

        System.out.println("Input Tag new name");
        String name = scanner.nextLine();

        TagDto tagDto = new TagDto();
        tagDto.setId(id);
        tagDto.setName(name);
        tagController.update(tagDto);
        System.out.println(Message.SUCCESSFUL_OPERATION.getMessage());
    }

    @Override
    void delete() {
        Long id = getValidateIdFromScanner();
        tagController.deleteById(id);
        System.out.println(Message.SUCCESSFUL_OPERATION.getMessage());
    }

    @Override
    void findAll() {
        System.out.println("Tag List");
        tagController.findAll().forEach(System.out::println);
    }

    public void showSecondMenu() {
        System.out.println("Tag control menu. What do you want to do?");
        super.showSecondMenu();
    }
}