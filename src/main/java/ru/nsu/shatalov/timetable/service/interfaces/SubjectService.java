package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Subject;

public interface SubjectService {
    void addSubject(Subject subject);

    Subject getSubjectBy(int id);

    Subject updateSubject(Subject subject);

    List<Subject> getAllSubjects();

    void deleteSubject(int id);
}
