package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.dto.TimeSlotDTO;

public interface TimeSlotService {

  TimeSlotDTO save(TimeSlotDTO timeSlot);

  List<TimeSlotDTO> getAll();

  TimeSlotDTO getById(Long id);
}
