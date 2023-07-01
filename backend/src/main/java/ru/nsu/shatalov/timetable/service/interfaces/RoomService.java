package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.dto.RoomDTO;

public interface RoomService {

  RoomDTO save(RoomDTO room);

  RoomDTO getById(Long id);

  RoomDTO update(RoomDTO room, Long id);

  List<RoomDTO> getAll();

  void delete(Long id);
}
