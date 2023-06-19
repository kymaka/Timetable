package ru.nsu.shatalov.timetable.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.service.impl.TimetableServiceImpl;

@RestController
public class TimetableController {

  private final TimetableServiceImpl service;

  public TimetableController(TimetableServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/generate")
  public ResponseEntity<Boolean> generateTimetable() {
    if (service.generateTimetable()) {
      return new ResponseEntity<>(true, HttpStatus.OK);
    }
    return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
  }
}
