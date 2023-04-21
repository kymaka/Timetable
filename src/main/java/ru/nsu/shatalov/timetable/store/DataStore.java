package ru.nsu.shatalov.timetable.store;

import java.util.ArrayList;
import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Room;
import ru.nsu.shatalov.timetable.model.constraint.Subject;

public class DataStore {
    private final List<Subject> subjects;

    private final List<Room> rooms;

    public DataStore() {
        this.subjects = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getAllSubjects() {
        return new ArrayList<>(subjects);
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }
}
