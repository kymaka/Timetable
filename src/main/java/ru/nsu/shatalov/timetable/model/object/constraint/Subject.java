package ru.nsu.shatalov.timetable.model.object.constraint;

import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.enums.SubjectType;

import java.util.concurrent.atomic.AtomicInteger;

public class Subject {

  private static final AtomicInteger idCount = new AtomicInteger(0);

  private final int id;

  private final String name;

  private final RoomType roomType;

  private final SubjectType subjectType;

  public Subject(String name, RoomType roomType, SubjectType subjectType) {
    this.name = name;
    this.roomType = roomType;
    this.subjectType = subjectType;
    this.id = idCount.getAndIncrement();
  }

  public String getName() {
    return this.name;
  }

  public RoomType getRoomType() {
    return this.roomType;
  }

  public SubjectType getSubjectType() {
    return this.subjectType;
  }

  public int getId() {
    return id;
  }
}
