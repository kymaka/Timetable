package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.shatalov.timetable.dto.TimetableEntryDTO;
import ru.nsu.shatalov.timetable.service.interfaces.TimetableEntryService;

@RestController
@RequestMapping("/entry")
public class TimetableEntryController {

  private final TimetableEntryService service;

  public TimetableEntryController(TimetableEntryService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<TimetableEntryDTO>> getAllTimetableEntries() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<TimetableEntryDTO> deleteTimetableEntry(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(null, HttpStatus.GONE);
  }
}
