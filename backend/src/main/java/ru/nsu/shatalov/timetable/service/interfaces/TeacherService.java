package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.dto.TeacherDTO;

public interface TeacherService {
  TeacherDTO save(TeacherDTO teacher);

  List<TeacherDTO> getAll();

  TeacherDTO getById(Long id);

  void delete(Long id);
}
