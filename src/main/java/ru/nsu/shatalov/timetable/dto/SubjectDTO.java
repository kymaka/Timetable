package ru.nsu.shatalov.timetable.dto;

import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.enums.SubjectType;

public class SubjectDTO {

  private String name;

  private RoomType roomType;

  private SubjectType subjectType;

  public SubjectDTO(String name, RoomType roomType, SubjectType subjectType) {
    this.name = name;
    this.roomType = roomType;
    this.subjectType = subjectType;
  }

  public SubjectDTO() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(RoomType roomType) {
    this.roomType = roomType;
  }

  public SubjectType getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(SubjectType subjectType) {
    this.subjectType = subjectType;
  }
}
