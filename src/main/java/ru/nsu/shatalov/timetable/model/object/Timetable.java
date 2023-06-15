package ru.nsu.shatalov.timetable.model.object;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import ru.nsu.shatalov.timetable.model.object.constraint.StudentGroup;

@Entity
public class Timetable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne
  @Cascade(CascadeType.ALL)
  private StudentGroup studentGroup;

  private Timetable(StudentGroup studentGroup) {
    this.studentGroup = studentGroup;
  }

  public Timetable() {}

  public void setStudentGroup(StudentGroup studentGroup) {
    this.studentGroup = studentGroup;
  }

  public StudentGroup getStudentGroup() {
    return this.studentGroup;
  }
}
