package ru.nsu.shatalov.timetable.model.object.constraint;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;

@Entity
public class StudentGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String number;

  @OneToMany private List<TimetableEntry> timetableEntries;

  @ManyToMany(fetch = FetchType.LAZY)
  private List<Subject> subjects;

  public StudentGroup(String number, List<Subject> subjects) {
    this.number = number;
    this.subjects = subjects;
    this.timetableEntries = new ArrayList<>();
  }

  public StudentGroup() {}

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String newNumber) {
    this.number = newNumber;
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

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }

  public List<TimetableEntry> getTimetableEntries() {
    return timetableEntries;
  }

  public void setTimetableEntries(List<TimetableEntry> timetableEntries) {
    this.timetableEntries = timetableEntries;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
