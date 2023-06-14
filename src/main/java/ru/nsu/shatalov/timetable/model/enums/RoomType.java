package ru.nsu.shatalov.timetable.model.enums;

public enum RoomType {
  Terminal("Terminal", 20, 0),
  Lecture("Lecture", 200, 1),
  General("General", 50, 2);

  RoomType(String label, int capacity, int integer) {
    this.label = label;
    this.capacity = capacity;
    this.integer = integer;
  }

  private final String label;

  private final int capacity;

  private final int integer;

  public String getLabel() {
    return label;
  }

  public int getCapacity() {
    return capacity;
  }

  public int toInt() {
    return integer;
  }
}
