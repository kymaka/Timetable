package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;

public interface RoomService {

  void save(Room room);

  Room getById(Long id);

  Room update(Room room, Long id);

  List<Room> getAll();

  void delete(Long id);
}
