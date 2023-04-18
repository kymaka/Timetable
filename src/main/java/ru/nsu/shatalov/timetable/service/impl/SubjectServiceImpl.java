package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Subject;
import ru.nsu.shatalov.timetable.repository.SubjectRepository;
import ru.nsu.shatalov.timetable.service.interfaces.SubjectService;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository repository) {
        this.subjectRepository = repository;
    }
    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubjectBy(int id) {
        return null;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return null;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.getAllSubjects();
    }

    @Override
    public void deleteSubject(int id) {

    }
}
