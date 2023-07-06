package ru.nsu.shatalov.timetable.model.object.constraint;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import ru.nsu.shatalov.timetable.model.enums.Day;

import java.util.List;

@Entity
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @Cascade(CascadeType.PERSIST)
  @ManyToMany
  private List<Subject> subjects;

  @Enumerated(EnumType.ORDINAL)
  private List<Day> workingDays;

  public Teacher(String name, List<Subject> subjects, List<Day> days) {
    this.name = name;
    this.subjects = subjects;
    this.workingDays = days;
  }

  public Teacher() {}

  public List<Day> getWorkingDays() {
    return workingDays;
  }

  public String getName() {
    return name;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }

  public void setWorkingDays(List<Day> workingDays) {
    this.workingDays = workingDays;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
