package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.model.object.TimeSlot;
import ru.nsu.shatalov.timetable.service.interfaces.TimeSlotService;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

  private final TimeSlotService service;

  public TimeSlotController(TimeSlotService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<TimeSlot> getTimeSlot(@PathVariable Long id) {
    return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<TimeSlot>> getAllTimeSlots() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }
}
