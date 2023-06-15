package ru.nsu.shatalov.timetable.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.service.interfaces.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

  private final RoomService service;

  public RoomController(RoomService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Room> getRoom(@PathVariable Long id) {
    return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Room>> getAllRooms() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }
}
