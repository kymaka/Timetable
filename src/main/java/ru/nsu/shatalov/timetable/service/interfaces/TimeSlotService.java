package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.TimeSlot;

public interface TimeSlotService {

  void save(TimeSlot timeSlot);

  List<TimeSlot> getAll();

  TimeSlot getById(Long id);
}
