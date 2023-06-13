package ru.nsu.shatalov.timetable.model.object;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;

public class Group {

  private String number;

  private final List<Subject> subjects;

  public Group(String number, List<Subject> subjects) {
    this.number = number;
    this.subjects = subjects;
  }

  public String getNumber() {
    return this.number;
  }

  public String setNumber(String newNumber) {
    this.number = newNumber;
    return this.number;
  }

  public List<Subject> getSubjects() {
    return this.subjects;
  }

  public Subject getSubjectByID(int id) {
    return this.subjects.get(id);
  }

  public List<Subject> addSubject(Subject subject) {
    this.subjects.add(subject);
    return this.subjects;
  }
}
