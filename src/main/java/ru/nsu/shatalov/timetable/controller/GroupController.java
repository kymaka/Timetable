package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.model.object.StudentGroup;
import ru.nsu.shatalov.timetable.service.impl.GroupServiceImpl;

@RestController
@RequestMapping("/groups")
public class GroupController {

  private final GroupServiceImpl service;

  public GroupController(GroupServiceImpl service) {
    this.service = service;
  }

  @GetMapping("/all")
  public ResponseEntity<List<StudentGroup>> getAllGroups() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<StudentGroup> createGroup(@RequestBody StudentGroup studentGroup) {
    StudentGroup newStudentGroup =
        service.save(new StudentGroup(studentGroup.getNumber(), studentGroup.getSubjects()));
    return new ResponseEntity<>(newStudentGroup, HttpStatus.CREATED);
  }
}
