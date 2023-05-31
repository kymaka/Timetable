package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;

public interface TeacherService {
  void addTeacher(Teacher teacher);

  List<Teacher> getAllTeachers();
}
