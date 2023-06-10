package ru.nsu.shatalov.timetable.store;

import java.util.ArrayList;
import java.util.List;
import ru.nsu.shatalov.timetable.model.object.Group;
import ru.nsu.shatalov.timetable.model.object.TimeSlot;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;

public class DataStore {
  private final List<Subject> subjects;

  private final List<Room> rooms;

  private final List<Teacher> teachers;

  private final List<Group> groups;

  private final List<TimeSlot> timeSlots;

  public DataStore() {
    this.subjects = new ArrayList<>();
    this.rooms = new ArrayList<>();
    this.teachers = new ArrayList<>();
    this.groups = new ArrayList<>();
    this.timeSlots = new ArrayList<>();
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

  public void addTeacher(Teacher teacher) {
    teachers.add(teacher);
  }

  public List<Teacher> getAllTeachers() {
    return new ArrayList<>(teachers);
  }

  public void addGroup(Group group) { groups.add(group); }

  public List<Group> getAllGroups() { return new ArrayList<>(groups); }

  public void addTimeSlot(TimeSlot timeSlot) { timeSlots.add(timeSlot); }

  public List<TimeSlot> getAllTimeSlots() { return new ArrayList<>(timeSlots); }
}
