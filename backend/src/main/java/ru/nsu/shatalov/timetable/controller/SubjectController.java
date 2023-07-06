package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.shatalov.timetable.dto.SubjectDTO;
import ru.nsu.shatalov.timetable.service.interfaces.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

  private final SubjectService service;

  public SubjectController(SubjectService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubjectDTO> getSubject(@PathVariable Long id) {
    SubjectDTO subject = service.getById(id);
    if (subject != null) {
      return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/all")
  public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<SubjectDTO> saveSubject(@RequestBody SubjectDTO subject) {
    if (subject != null) {
      SubjectDTO newSubject = service.save(subject);
      return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<SubjectDTO> deleteSubject(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(null, HttpStatus.GONE);
  }
}
