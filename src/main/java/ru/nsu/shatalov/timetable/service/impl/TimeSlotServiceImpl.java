package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.TimeSlot;
import ru.nsu.shatalov.timetable.repository.TimeSlotRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TimeSlotService;

public class TimeSlotServiceImpl implements TimeSlotService {

  private final TimeSlotRepository repository;

  public TimeSlotServiceImpl(TimeSlotRepository repository) {
    this.repository = repository;
  }

  @Override
  public void addTimeSlot(TimeSlot timeSlot) {
    repository.save(timeSlot);
  }

  @Override
  public List<TimeSlot> getAllTimeSlots() {
    return repository.getAll();
  }
}
