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

  private String time;

  public TimeSlot(String time) {
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
    return time.equals(other.time);
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String newTime) {
    this.time = newTime;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
