package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.dto.TeacherDTO;
import ru.nsu.shatalov.timetable.service.interfaces.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

  private final TeacherService service;

  public TeacherController(TeacherService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<TeacherDTO> getTeacher(@PathVariable Long id) {
    TeacherDTO teacher = service.getById(id);
    if (teacher != null) {
      return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/all")
  public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacher) {
    TeacherDTO newTeacher = service.save(teacher);
    return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
  }
}
