package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.repository.RoomRepository;
import ru.nsu.shatalov.timetable.service.interfaces.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

  private final RoomRepository repository;

  public RoomServiceImpl(RoomRepository repository) {
    this.repository = repository;
  }

  @Override
  public Room save(Room room) {
    return repository.save(room);
  }

  @Override
  public Room getById(Long id) {
    return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
  }

  @Override
  public Room update(Room room, Long id) {
    return null;
  }

  @Override
  public List<Room> getAll() {
    return repository.findAll();
  }

  @Override
  public void delete(Long id) {}
}
