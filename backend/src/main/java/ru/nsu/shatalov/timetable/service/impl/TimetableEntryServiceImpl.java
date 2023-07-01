package ru.nsu.shatalov.timetable.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.dto.TimetableEntryDTO;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;
import ru.nsu.shatalov.timetable.repository.TimetableEntryRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TimetableEntryService;

@Service
public class TimetableEntryServiceImpl implements TimetableEntryService {

  private final TimetableEntryRepository repository;

  private final ModelMapper modelMapper;

  public TimetableEntryServiceImpl(TimetableEntryRepository repository) {
    this.repository = repository;
    this.modelMapper = new ModelMapper();
  }

  @Override
  public TimetableEntryDTO save(TimetableEntryDTO timetableEntryDTO) {
    TimetableEntry timetableEntry = modelMapper.map(timetableEntryDTO, TimetableEntry.class);
    repository.save(timetableEntry);
    return modelMapper.map(timetableEntry, TimetableEntryDTO.class);
  }

  @Override
  public TimetableEntryDTO getById(Long id) {
    TimetableEntry timetableEntry =
        repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (timetableEntry != null) {
      return modelMapper.map(timetableEntry, TimetableEntryDTO.class);
    }
    return null;
  }

  @Override
  public List<TimetableEntryDTO> getAll() {
    List<TimetableEntry> timetableEntries = repository.findAll();
    List<TimetableEntryDTO> timetableEntryDTOS = new LinkedList<>();
    for (TimetableEntry timetableEntry : timetableEntries) {
      timetableEntryDTOS.add(modelMapper.map(timetableEntry, TimetableEntryDTO.class));
    }
    return timetableEntryDTOS;
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
