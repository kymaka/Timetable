package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.dto.TimetableEntryDTO;

public interface TimetableEntryService {

  TimetableEntryDTO save(TimetableEntryDTO timetableEntry);

  TimetableEntryDTO getById(Long id);

  List<TimetableEntryDTO> getAll();

  void delete(Long id);
}
