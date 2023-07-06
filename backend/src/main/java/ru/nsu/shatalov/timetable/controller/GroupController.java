package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.shatalov.timetable.dto.StudentGroupDTO;
import ru.nsu.shatalov.timetable.dto.TimetableEntryDTO;
import ru.nsu.shatalov.timetable.service.impl.GroupServiceImpl;

@RestController
@RequestMapping("/groups")
public class GroupController {

  private final GroupServiceImpl service;

  public GroupController(GroupServiceImpl service) {
    this.service = service;
  }

  @GetMapping("/all")
  public ResponseEntity<List<StudentGroupDTO>> getAllGroups() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentGroupDTO> getGroup(@PathVariable Long id) {
    StudentGroupDTO studentGroup = service.getById(id);
    if (studentGroup != null) {
      return new ResponseEntity<>(studentGroup, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/number/{number}")
  public ResponseEntity<StudentGroupDTO> getGroup(@PathVariable String number) {
    StudentGroupDTO studentGroup = service.getByNumber(number);
    if (studentGroup != null) {
      return new ResponseEntity<>(studentGroup, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/timetable/{number}")
  public ResponseEntity<List<TimetableEntryDTO>> getGroupTimetable(@PathVariable String number) {
    return new ResponseEntity<>(service.getTimetable(number), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<StudentGroupDTO> createGroup(@RequestBody StudentGroupDTO studentGroup) {
    if (studentGroup != null) {
      StudentGroupDTO newStudentGroup = service.save(studentGroup);
      return new ResponseEntity<>(newStudentGroup, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentGroupDTO> updateGroup(
      @RequestBody StudentGroupDTO newStudentGroup, @PathVariable("id") Long id) {
    StudentGroupDTO updatedStudentGroup = service.update(newStudentGroup, id);
    if (newStudentGroup != null) {
      return new ResponseEntity<>(updatedStudentGroup, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<StudentGroupDTO> deleteGroup(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(null, HttpStatus.GONE);
  }
}
