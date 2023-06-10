package ru.nsu.shatalov.timetable.model.object;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;

public class Group {

  private final String number;

  private final List<Subject> subjects;

  public Group(String number, List<Subject> subjects) {
    this.number = number;
    this.subjects = subjects;
  }

  public String getNumber() {
    return this.number;
  }

  public List<Subject> getSubjects() {
    return this.subjects;
  }
}
