package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;
import ru.nsu.shatalov.timetable.repository.SubjectRepository;
import ru.nsu.shatalov.timetable.service.interfaces.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

  private final SubjectRepository repository;

  public SubjectServiceImpl(SubjectRepository repository) {
    this.repository = repository;
  }

  @Override
  public void save(Subject subject) {
    repository.save(subject);
  }

  @Override
  public Subject getById(Long id) {
    return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
  }

  @Override
  public Subject update(Subject subject, Long id) {
    return null;
  }

  @Override
  public List<Subject> getAll() {
    return repository.findAll();
  }

  @Override
  public void delete(Long id) {}
}
