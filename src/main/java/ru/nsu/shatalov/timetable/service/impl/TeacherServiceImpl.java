package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Teacher;
import ru.nsu.shatalov.timetable.repository.TeacherRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TeacherService;

public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository repository;

  public TeacherServiceImpl(TeacherRepository repository) {
    this.repository = repository;
  }

  @Override
  public void addTeacher(Teacher teacher) {
    repository.save(teacher);
  }

  @Override
  public List<Teacher> getAllTeachers() {
    return repository.getAll();
  }
}
