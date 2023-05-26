package ru.nsu.shatalov.timetable.model.object;

public class Group {

  private final String number;

  private final Timetable timetable;

  public Group(String number) {
    this.number = number;
    this.timetable = new Timetable();
  }

  public String getNumber() {
    return this.number;
  }

  public Timetable getTimetable() {
    return this.timetable;
  }
}
