package ru.nsu.shatalov.timetable.model.object.constraint;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ru.nsu.shatalov.timetable.model.enums.RoomType;

@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String number;

  @Enumerated(EnumType.ORDINAL)
  private RoomType type;

  public Room(String number, RoomType type) {
    this.number = number;
    this.type = type;
  }

  public Room() {}

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
