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
import ru.nsu.shatalov.timetable.dto.RoomDTO;
import ru.nsu.shatalov.timetable.service.interfaces.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

  private final RoomService service;

  public RoomController(RoomService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<RoomDTO> getRoom(@PathVariable Long id) {
    RoomDTO room = service.getById(id);
    if (room != null) {
      return new ResponseEntity<>(room, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/all")
  public ResponseEntity<List<RoomDTO>> getAllRooms() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<RoomDTO> saveRoom(@RequestBody RoomDTO room) {
    RoomDTO newRoom = service.save(room);
    return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
  }
}
