package by.itacademy.company.Pattern;

import by.itacademy.company.annotation.ThemeProject;

@ThemeProject(nameProject = "------------------------------------\nТема итогового проекта:\"ИТ компании\"\n------------------------------------\n")
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        System.out.println(Singleton.class.getAnnotation(ThemeProject.class).nameProject());
        if (instance == null) instance = new Singleton();
        return instance;
    }
}
