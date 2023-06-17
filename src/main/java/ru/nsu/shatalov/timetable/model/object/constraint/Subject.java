package ru.nsu.shatalov.timetable.model.object.constraint;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.enums.SubjectType;

@Entity
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @Enumerated(EnumType.ORDINAL)
  private RoomType roomType;

  @Enumerated(EnumType.ORDINAL)
  private SubjectType subjectType;

  public Subject(String name, RoomType roomType, SubjectType subjectType) {
    this.name = name;
    this.roomType = roomType;
    this.subjectType = subjectType;
  }

  public Subject() {}

  public String getName() {
    return this.name;
  }

  public RoomType getRoomType() {
    return this.roomType;
  }

  public SubjectType getSubjectType() {
    return this.subjectType;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
