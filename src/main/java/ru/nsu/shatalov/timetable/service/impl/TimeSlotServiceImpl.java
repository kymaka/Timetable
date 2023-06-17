package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.model.object.constraint.TimeSlot;
import ru.nsu.shatalov.timetable.repository.TimeSlotRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TimeSlotService;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

  private final TimeSlotRepository repository;

  public TimeSlotServiceImpl(TimeSlotRepository repository) {
    this.repository = repository;
  }

  @Override
  public TimeSlot save(TimeSlot timeSlot) {
    return repository.save(timeSlot);
  }

  @Override
  public List<TimeSlot> getAll() {
    return repository.findAll();
  }

  @Override
  public TimeSlot getById(Long id) {
    return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
  }
}
