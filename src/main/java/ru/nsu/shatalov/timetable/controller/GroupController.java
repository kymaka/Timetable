package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.model.object.constraint.StudentGroup;
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

  @GetMapping("/{id}")
  public ResponseEntity<StudentGroup> getGroup(@PathVariable Long id) {
    StudentGroup studentGroup = service.getById(id);
    return new ResponseEntity<>(studentGroup, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<StudentGroup> createGroup(@RequestBody StudentGroup studentGroup) {
    StudentGroup newStudentGroup =
        service.save(new StudentGroup(studentGroup.getNumber(), studentGroup.getSubjects()));
    return new ResponseEntity<>(newStudentGroup, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentGroup> updateGroup(
      @RequestBody StudentGroup newStudentGroup, @PathVariable("id") Long id) {
    StudentGroup updatedStudentGroup = service.update(newStudentGroup, id);
    return new ResponseEntity<>(updatedStudentGroup, HttpStatus.CREATED);
  }
}
