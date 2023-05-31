package ru.nsu.shatalov.timetable.repository;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.store.DataStore;

public class RoomRepository {

  private final DataStore dataStore;

  public RoomRepository(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  public void save(Room room) {
    dataStore.addRoom(room);
  }

  public List<Room> getAllRooms() {
    return dataStore.getAllRooms();
  }
}
