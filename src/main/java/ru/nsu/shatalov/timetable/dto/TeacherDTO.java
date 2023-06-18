package ru.nsu.shatalov.timetable.dto;

import java.util.List;
import ru.nsu.shatalov.timetable.model.enums.Day;

public class TeacherDTO {
  private String name;

  private List<SubjectDTO> subjects;

  private List<Day> workingDays;

  public TeacherDTO(String name, List<SubjectDTO> subjects, List<Day> days) {
    this.name = name;
    this.subjects = subjects;
    this.workingDays = days;
  }

  public TeacherDTO() {}

  public List<Day> getWorkingDays() {
    return workingDays;
  }

  public String getName() {
    return name;
  }

  public List<SubjectDTO> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<SubjectDTO> subjects) {
    this.subjects = subjects;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setWorkingDays(List<Day> workingDays) {
    this.workingDays = workingDays;
  }
}
