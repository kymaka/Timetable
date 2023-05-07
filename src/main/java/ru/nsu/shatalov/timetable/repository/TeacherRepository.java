package ru.nsu.shatalov.timetable.repository;

import java.util.List;
import ru.nsu.shatalov.timetable.model.constraint.Teacher;
import ru.nsu.shatalov.timetable.store.DataStore;

public class TeacherRepository {

  private final DataStore dataStore;

  public TeacherRepository(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  public void save(Teacher teacher) {
    dataStore.addTeacher(teacher);
  }

  public List<Teacher> getAll() {
    return dataStore.getAllTeachers();
  }
}
