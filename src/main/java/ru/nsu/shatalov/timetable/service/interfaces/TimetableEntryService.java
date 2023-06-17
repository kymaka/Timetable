package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;

public interface TimetableEntryService {

  void save(TimetableEntry timetableEntry);

  TimetableEntry getById(Long id);

  List<TimetableEntry> getAll();

  void delete(Long id);
}
