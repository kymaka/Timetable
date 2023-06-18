package ru.nsu.shatalov.timetable.dto;

import java.util.List;

public class StudentGroupDTO {

  private String number;
  private List<SubjectDTO> subjects;
  private List<TimetableEntryDTO> timetableEntries;

  // Constructors, getters, and setters

  public StudentGroupDTO() {}

  public StudentGroupDTO(
      String number, List<SubjectDTO> subjects, List<TimetableEntryDTO> timetableEntries) {
    this.number = number;
    this.subjects = subjects;
    this.timetableEntries = timetableEntries;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public List<SubjectDTO> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<SubjectDTO> subjects) {
    this.subjects = subjects;
  }

  public List<TimetableEntryDTO> getTimetableEntries() {
    return timetableEntries;
  }

  public void setTimetableEntries(List<TimetableEntryDTO> timetableEntries) {
    this.timetableEntries = timetableEntries;
  }
}
