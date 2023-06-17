package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;
import ru.nsu.shatalov.timetable.service.interfaces.TimetableEntryService;

@RestController
@RequestMapping("/entry")
public class TimetableEntryController {

  private final TimetableEntryService service;

  public TimetableEntryController(TimetableEntryService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<TimetableEntry>> getAllTimetableEntries() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }
}
