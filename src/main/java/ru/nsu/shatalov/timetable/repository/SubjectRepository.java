package ru.nsu.shatalov.timetable.repository;

import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Subject;
import ru.nsu.shatalov.timetable.store.DataStore;

public class SubjectRepository {
    private final DataStore dataStore;

    public SubjectRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public Subject save(Subject subject) {
        dataStore.addSubject(subject);
        return subject;
    }

    public List<Subject> getAllSubjects() {
        return dataStore.getAllSubjects();
    }
}
