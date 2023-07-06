package ru.nsu.shatalov.timetable.dto;

import ru.nsu.shatalov.timetable.model.enums.Day;

public class TimetableEntryDTO {

  private Long id;

  private RoomDTO room;

  private SubjectDTO subject;

  private TimeSlotDTO timeSlot;

  private TeacherDTO teacher;

  private Day day;

  public TimetableEntryDTO(
      RoomDTO room, SubjectDTO subject, TimeSlotDTO timeSlot, TeacherDTO teacher, Day day) {
    this.room = room;
    this.subject = subject;
    this.timeSlot = timeSlot;
    this.teacher = teacher;
    this.day = day;
  }

  public TimetableEntryDTO() {}

  public RoomDTO getRoom() {
    return room;
  }

  public void setRoom(RoomDTO room) {
    this.room = room;
  }

  public SubjectDTO getSubject() {
    return subject;
  }

  public void setSubject(SubjectDTO subject) {
    this.subject = subject;
  }

  public TimeSlotDTO getTimeSlot() {
    return timeSlot;
  }

  public void setTimeSlot(TimeSlotDTO timeSlot) {
    this.timeSlot = timeSlot;
  }

  public TeacherDTO getTeacher() {
    return teacher;
  }

  public void setTeacher(TeacherDTO teacher) {
    this.teacher = teacher;
  }

  public Day getDay() {
    return day;
  }

  public void setDay(Day day) {
    this.day = day;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
