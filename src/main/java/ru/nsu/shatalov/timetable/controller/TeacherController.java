package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;
import ru.nsu.shatalov.timetable.service.interfaces.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

  private final TeacherService service;

  public TeacherController(TeacherService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) {
    return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Teacher>> getAllTeachers() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }
}
