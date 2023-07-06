package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.dto.StudentGroupDTO;
import ru.nsu.shatalov.timetable.dto.TimetableEntryDTO;

public interface GroupService {

  StudentGroupDTO save(StudentGroupDTO studentGroupDTO);

  StudentGroupDTO getById(Long id);

  StudentGroupDTO getByNumber(String number);

  List<TimetableEntryDTO> getTimetable(String number);

  StudentGroupDTO update(StudentGroupDTO studentGroupDTO, Long id);

  List<StudentGroupDTO> getAll();

  void delete(StudentGroupDTO studentGroupDTO);
}
