package ru.nsu.shatalov.timetable.model.constraint;

import java.util.List;

public class Teacher {
    private String name;

    private List<Subject> subjects;

    public Teacher(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
