package ru.nsu.shatalov.timetable.model.enums;

public enum Day {
  Monday(1),
  Tuesday(2),
  Wednesday(3),
  Thursday(4),
  Friday(5),
  Saturday(6),
  Sunday(7);

  Day(int num) {
    this.num = num;
  }

  private final int num;

  public int getNum() {
    return this.num;
  }
}
