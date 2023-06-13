package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.TimeSlot;

public interface TimeSlotService {

  void addTimeSlot(TimeSlot timeSlot);

  List<TimeSlot> getAllTimeSlots();
}
