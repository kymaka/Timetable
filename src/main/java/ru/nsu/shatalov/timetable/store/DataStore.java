package ru.nsu.shatalov.timetable.store;

import java.util.ArrayList;
import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Subject;

public class DataStore {
    private final List<Subject> subjects;


    public DataStore() {
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getAllSubjects() {
        return new ArrayList<>(subjects);
    }
}
