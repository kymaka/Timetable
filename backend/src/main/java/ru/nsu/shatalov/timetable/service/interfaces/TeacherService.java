package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.dto.TeacherDTO;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;

public interface TeacherService {
  TeacherDTO save(TeacherDTO teacher);

  List<TeacherDTO> getAll();

  TeacherDTO getById(Long id);
}
