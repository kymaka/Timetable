package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;

public interface TeacherService {
  void save(Teacher teacher);

  List<Teacher> getAll();

  Teacher getById(Long id);
}
