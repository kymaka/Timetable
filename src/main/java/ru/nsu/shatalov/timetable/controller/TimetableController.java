package ru.nsu.shatalov.timetable.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.service.impl.TimetableServiceImpl;

@RestController
public class TimetableController {

  private final TimetableServiceImpl service;

  public TimetableController(TimetableServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/generate")
  public void generateTimetable() {
    service.generateTimetable();
  }
}
