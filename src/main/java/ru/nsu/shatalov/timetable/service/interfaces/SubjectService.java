package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;

public interface SubjectService {
  void save(Subject subject);

  Subject getById(Long id);

  Subject update(Subject subject, Long id);

  List<Subject> getAll();

  void delete(Long id);
}
