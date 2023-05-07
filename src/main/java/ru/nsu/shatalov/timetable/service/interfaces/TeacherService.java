package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Teacher;

public interface TeacherService {
  public void addTeacher(Teacher teacher);

  public List<Teacher> getAllTeachers();
}
