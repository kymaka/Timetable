package ru.nsu.shatalov.timetable.model.object.constraint;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String number;

  @Enumerated(EnumType.ORDINAL)
  private RoomType type;

  @Cascade(CascadeType.PERSIST)
  @OneToMany
  private List<TimetableEntry> entries;

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

  public List<TimetableEntry> getEntries() {
    return this.entries;
  }

  public void setEntry(List<TimetableEntry> timetableEntry) {
    this.entries = timetableEntry;
  }
}
