package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;
import ru.nsu.shatalov.timetable.repository.TeacherRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository repository;

  public TeacherServiceImpl(TeacherRepository repository) {
    this.repository = repository;
  }

  @Override
  public Teacher save(Teacher teacher) {
    return repository.save(teacher);
  }

  @Override
  public List<Teacher> getAll() {
    return repository.findAll();
  }

  @Override
  public Teacher getById(Long id) {
    return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
  }
}
