package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.shatalov.timetable.dto.TimeSlotDTO;
import ru.nsu.shatalov.timetable.service.interfaces.TimeSlotService;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

  private final TimeSlotService service;

  public TimeSlotController(TimeSlotService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<TimeSlotDTO> getTimeSlot(@PathVariable Long id) {
    TimeSlotDTO timeSlot = service.getById(id);
    if (timeSlot != null) {
      return new ResponseEntity<>(timeSlot, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/all")
  public ResponseEntity<List<TimeSlotDTO>> getAllTimeSlots() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<TimeSlotDTO> saveTimeSlot(@RequestBody TimeSlotDTO timeSlot) {
    TimeSlotDTO newTimeSlot = service.save(timeSlot);
    return new ResponseEntity<>(newTimeSlot, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<TimeSlotDTO> deleteTimeSlot(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(null, HttpStatus.GONE);
  }
}
