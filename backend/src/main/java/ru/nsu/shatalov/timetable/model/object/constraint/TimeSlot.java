package ru.nsu.shatalov.timetable.model.object.constraint;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TimeSlot {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private int time;

  public TimeSlot(int time) {
    this.time = time;
  }

  public TimeSlot() {}

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    TimeSlot other = (TimeSlot) obj;
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
