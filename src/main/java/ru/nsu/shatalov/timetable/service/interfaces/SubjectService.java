package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.dto.SubjectDTO;

public interface SubjectService {
  SubjectDTO save(SubjectDTO subject);

  SubjectDTO getById(Long id);

  SubjectDTO update(SubjectDTO subject, Long id);

  List<SubjectDTO> getAll();

  void delete(Long id);
}
