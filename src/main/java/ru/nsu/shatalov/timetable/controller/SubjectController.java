package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;
import ru.nsu.shatalov.timetable.service.interfaces.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

  private final SubjectService service;

  public SubjectController(SubjectService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Subject> getSubject(@PathVariable Long id) {
    Subject subject = service.getById(id);
    return new ResponseEntity<>(subject, HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Subject>> getAllSubjects() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }
}
