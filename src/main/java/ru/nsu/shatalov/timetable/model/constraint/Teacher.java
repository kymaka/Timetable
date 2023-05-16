package ru.nsu.shatalov.timetable.model.constraint;

import ru.nsu.shatalov.timetable.model.enums.Day;

import java.util.List;

public class Teacher {
  private final String name;

  private final List<Subject> subjects;

  private final List<Day> workingDays;

  public Teacher(String name, List<Subject> subjects, List<Day> days) {
    this.name = name;
    this.subjects = subjects;
    this.workingDays = days;
  }

  public List<Day> getWorkingDays() {
    return workingDays;
  }

  public String getName() {
    return name;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }
}
