package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Room;
import ru.nsu.shatalov.timetable.repository.RoomRepository;
import ru.nsu.shatalov.timetable.service.interfaces.RoomService;

public class RoomServiceImpl implements RoomService {

  private final RoomRepository repository;

  public RoomServiceImpl(RoomRepository repository) {
    this.repository = repository;
  }

  @Override
  public void addRoom(Room room) {
    repository.save(room);
  }

  @Override
  public Room getRoomBy(int id) {
    return null;
  }

  @Override
  public Room updateRoom(Room room) {
    return null;
  }

  @Override
  public List<Room> getAllRooms() {
    return repository.getAllRooms();
  }

  @Override
  public void deleteRoom(int id) {}
}
