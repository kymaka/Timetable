package ru.nsu.shatalov.timetable.model.object;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;

@Entity
public class StudentGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String number;

  @ManyToMany private List<Subject> subjects;

  public StudentGroup(String number, List<Subject> subjects) {
    this.number = number;
    this.subjects = subjects;
  }

  public StudentGroup() {}

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
