package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Room;

public interface RoomService {

    void addRoom(Room room);

    Room getRoomBy(int id);

    Room updateRoom(Room room);

    List<Room> getAllRooms();

    void deleteRoom(int id);
}
