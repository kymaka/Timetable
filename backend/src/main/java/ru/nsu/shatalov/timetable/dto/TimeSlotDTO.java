package ru.nsu.shatalov.timetable.dto;

public class TimeSlotDTO {

  private Long id;

  private String time;

  public TimeSlotDTO(String time) {
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
    return time.equals(other.time);
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String newTime) {
    this.time = newTime;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
