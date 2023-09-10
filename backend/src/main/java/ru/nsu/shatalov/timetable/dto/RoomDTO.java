package ru.nsu.shatalov.timetable.dto;

import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;

import java.util.ArrayList;
import java.util.List;

public class RoomDTO {

  private Long id;

  private String number;

  private RoomType type;

  private List<TimetableEntryDTO> entries;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<TimetableEntryDTO> getEntries() {
    return this.entries;
  }

  public void setEntries(List<TimetableEntryDTO> timetableEntry) {
    this.entries = timetableEntry;
  }
}
