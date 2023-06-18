package ru.nsu.shatalov.timetable.dto;

import ru.nsu.shatalov.timetable.model.enums.RoomType;

public class RoomDTO {

  private String number;

  private RoomType type;

  public RoomDTO(String number, RoomType type) {
    this.number = number;
    this.type = type;
  }

  public RoomDTO() {}

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public RoomType getType() {
    return type;
  }

  public void setType(RoomType type) {
    this.type = type;
  }
}
