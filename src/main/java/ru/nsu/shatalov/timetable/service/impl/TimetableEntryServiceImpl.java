package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;
import ru.nsu.shatalov.timetable.repository.TimetableEntryRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TimetableEntryService;

@Service
public class TimetableEntryServiceImpl implements TimetableEntryService {

  private final TimetableEntryRepository repository;

  public TimetableEntryServiceImpl(TimetableEntryRepository repository) {
    this.repository = repository;
  }

  @Override
  public void save(TimetableEntry timetableEntry) {
    repository.save(timetableEntry);
  }

  @Override
  public TimetableEntry getById(Long id) {
    return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
  }

  @Override
  public List<TimetableEntry> getAll() {
    return repository.findAll();
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
