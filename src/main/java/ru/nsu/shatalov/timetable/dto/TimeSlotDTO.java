package ru.nsu.shatalov.timetable.dto;

import ru.nsu.shatalov.timetable.model.object.constraint.TimeSlot;

public class TimeSlotDTO {

  private int time;

  public TimeSlotDTO(int time) {
    this.time = time;
  }

  public TimeSlotDTO() {}

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    TimeSlotDTO other = (TimeSlotDTO) obj;
    return time == other.time;
  }

  public int getTime() {
    return this.time;
  }

  public void setTime(int newTime) {
    this.time = newTime;
  }

  @Override
  public String toString() {
    return this.time / 100 + ":" + this.time % 100;
  }
}
