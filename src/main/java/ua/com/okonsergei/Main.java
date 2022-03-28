package ua.com.okonsergei;

import ua.com.okonsergei.utils.FlywayMigration;
import ua.com.okonsergei.view.MainView;

public class Main {

    public static void main(String[] args) {
        FlywayMigration.runFlyWay();
        MainView mainView = new MainView();
        mainView.run();
    }
}
